package com.tooklili.tookitem.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.tooklili.tookitem.config.ServerUrlConfig;
import com.tooklili.tookitem.model.Item;
import com.tooklili.tookitem.model.TookHotKeyword;
import com.tooklili.tookitem.model.enums.CateEnum;
import com.tooklili.tookitem.model.vo.ItemDetailVo;
import com.tooklili.tookitem.result.ListResult;
import com.tooklili.tookitem.result.PageResult;
import com.tooklili.tookitem.service.TookItemNineService;
import com.tooklili.tookitem.service.TookItemService;
import com.tooklili.tookitem.service.TookItemTwentyService;
import com.tooklili.tookitem.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shuai.ding
 * @date 2018年05月29日 下午9:25
 */
@Controller
public class ItemController {

    @Autowired
    private TookItemNineService tookItemNineService;

    @Autowired
    private TookItemTwentyService tookItemTwentyService;

    @Autowired
    private TookItemService tookItemService;

    @Autowired
    private ServerUrlConfig serverUrlConfig;


    /**
     * 获取热门关键字
     * @param count
     * @return
     */
    @RequestMapping("/random_keyword")
    @ResponseBody
    public ListResult<String> getRandomKeywords(Integer count){
        ListResult<String> result = new ListResult<String>();

        List<TookHotKeyword> tookHotKeywords =  tookItemService.getRandomKeywords(count);

        result.setData(Lists.transform(tookHotKeywords, new Function<TookHotKeyword, String>() {
            @Override
            public String apply(TookHotKeyword input) {
                return input.getKeyword();
            }
        }));
        return result;
    }


    /**
     * 查询产品列表
     * @param model
     * @param cateEnum nine 九块9  twenty 20元
     * @return
     */
    @RequestMapping("/query_item/{cateEnum}")
    public String queryItem(Model model,@PathVariable CateEnum cateEnum){
        if(cateEnum == null){
            model.addAttribute("error","分类id不能为空");
            return "error";
        }
        PageResult<Item> items = new PageResult<>();
        switch (cateEnum){
            case nine:
                items = tookItemNineService.findItemNine(1,10);
                break;
            case twenty:
                items = tookItemTwentyService.findItemTwenty(1,10);
                break;
        }
        model.addAttribute("items",items.getData());
        model.addAttribute("cate",cateEnum.toString());
        return "item";
    }


    /**
     * 请求商品列表模板
     * @param model
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/item_list")
    public String itemList(Model model,Integer currentPage, Integer pageSize,CateEnum cateEnum){
        PageResult<Item> items =new PageResult<>();

        switch (cateEnum){
            case nine:
                items = tookItemNineService.findItemNine(currentPage,pageSize);
                break;
            case twenty:
                items = tookItemTwentyService.findItemTwenty(currentPage,pageSize);
                break;
        }
        if(items.getData().size()==0){
            return "empty";
        }
        model.addAttribute("items",items.getData());
        return "item_list";
    }



    /**
     * 商品详情页
     * @return
     */
    @RequestMapping("/item_detail")
    public String toItemDetail(Model model, ItemDetailVo itemDetailVo){

        model.addAttribute("item",itemDetailVo);


        //随机获取4个商品
        Map<String,String> params0 = new HashMap<>();
        params0.put("size","4");
        String content0 = HttpClientUtils.doPost(serverUrlConfig.getRandomItemUrl(),params0);
        model.addAttribute("items",JSON.parseArray(JSON.parseObject(content0).get("data").toString(),Item.class));


        //获取淘口令
//        Map<String,String> params = new HashMap<>();
//        params.put("auctionid",itemDetailVo.getNumId());
//        String content = HttpClientUtils.doPost(serverUrlConfig.getTwdAndShortLinkInfoUrl(),params);
//        JSONObject jsonObject =  JSON.parseObject(content);
//        model.addAttribute("tklAndLink",JSON.parseObject(jsonObject.get("data").toString(),AlimamaItemLink.class));


        return "item_detail";
    }
}
