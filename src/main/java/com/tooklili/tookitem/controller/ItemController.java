package com.tooklili.tookitem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.tooklili.tookitem.config.ServerUrlConfig;
import com.tooklili.tookitem.mapper.TookAlimamaItemCateMapper;
import com.tooklili.tookitem.model.Item;
import com.tooklili.tookitem.model.TookAlimamaItemCate;
import com.tooklili.tookitem.model.TookHotKeyword;
import com.tooklili.tookitem.model.enums.CateEnum;
import com.tooklili.tookitem.model.vo.ItemDetailVo;
import com.tooklili.tookitem.model.vo.QueryItemVo;
import com.tooklili.tookitem.result.ListResult;
import com.tooklili.tookitem.result.PageResult;
import com.tooklili.tookitem.service.TookItemNineService;
import com.tooklili.tookitem.service.TookItemService;
import com.tooklili.tookitem.service.TookItemTwentyService;
import com.tooklili.tookitem.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static  final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private TookItemNineService tookItemNineService;

    @Autowired
    private TookItemTwentyService tookItemTwentyService;

    @Autowired
    private TookItemService tookItemService;

    @Autowired
    private ServerUrlConfig serverUrlConfig;

    @Autowired
    private TookAlimamaItemCateMapper tookAlimamaItemCateMapper;


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
    public String queryItem(Model model,@PathVariable CateEnum cateEnum,QueryItemVo queryItemVo){
        if(cateEnum == null){
            model.addAttribute("error","分类id不能为空");
            return "error";
        }

        //获取商品分类
        List<TookAlimamaItemCate> tookAlimamaItemCates = tookAlimamaItemCateMapper.getTookAlimamaItemCates();
        TookAlimamaItemCate tookAlimamaItemCate = new TookAlimamaItemCate();
        tookAlimamaItemCate.setId(-1);
        tookAlimamaItemCate.setItemCateName("全部");
        tookAlimamaItemCates.add(0,tookAlimamaItemCate);
        model.addAttribute("itemCates",tookAlimamaItemCates);


        PageResult<Item> items = new PageResult<>();
        switch (cateEnum){
            case nine:
                items = tookItemNineService.findItemNine(queryItemVo,1,10);
                break;
            case twenty:
                items = tookItemTwentyService.findItemTwenty(queryItemVo,1,10);
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
    public String itemList(Model model,Integer currentPage, Integer pageSize,CateEnum cateEnum,QueryItemVo queryItemVo){
        PageResult<Item> items =new PageResult<>();

        if(cateEnum == null){
            model.addAttribute("error","分类id不能为空");
            return "error";
        }

        switch (cateEnum){
            case nine:
                items = tookItemNineService.findItemNine(queryItemVo,currentPage,pageSize);
                break;
            case twenty:
                items = tookItemTwentyService.findItemTwenty(queryItemVo,currentPage,pageSize);
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

        //获取淘口令接口
        model.addAttribute("twdAndShortLinkInfoUrl",serverUrlConfig.getTwdAndShortLinkInfoUrl());


        return "item_detail";
    }

    /**
     * 品牌券商品
     * @return
     */
    @RequestMapping("/brand_coupon_items")
    public String brandCouponItems(){
        return "brand_coupon_item";
    }


    /**
     * 母婴主题
     * @return
     */
    @RequestMapping("/meternal_coupon_items")
    public String maternalCouponItems(){
        return "meternal_coupon_item";
    }

    /**
     * 好券直播
     * @return
     */
    @RequestMapping("/good/conpon/live")
    public String goodConponLive(){
        return "good_coupon_item";
    }



    /**
     * 通过物料id获取商品列表
     * @param materialId   物料id
     * @param currentPage  当前页
     * @param pageSize     页面大小
     * @param model
     * @return
     */
    @RequestMapping("/get_items_materialId")
    public String getItemsBymaterialId(Long materialId,Integer currentPage,Integer pageSize,Model model){
        Map<String,String> params = new HashMap<>();
        params.put("materialId",materialId+"");
        params.put("currentPage",currentPage+"");
        params.put("pageSize",pageSize+"");

        String content = HttpClientUtils.doPost(serverUrlConfig.getMaterialGetItemsUrl(),params);
        LOGGER.info(content);
        ListResult<Item> items = JSON.parseObject(content,new TypeReference< ListResult< Item>>(){});

        if(items.getData().size()==0){
            return "empty";
        }
        model.addAttribute("items",items.getData());
        return "item_list";
    }


    /**
     * 通过好券清单接口获取优惠券商品
     * @param q
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/getCouponItems")
    @ResponseBody
    public PageResult<Item> getCouponItems(String q,Long pageNo,Long pageSize){
        Map<String,String> params = new HashMap<>();
        params.put("q",q);
        if(pageNo != null){
            params.put("pageNo",String.valueOf(pageNo));
        }
        if(pageSize != null){
            params.put("pageSize",String.valueOf(pageSize));
        }

        String content = HttpClientUtils.doPost(serverUrlConfig.getGetCouponItemsUrl(),params);
        PageResult<Item> items = JSON.parseObject(content,new TypeReference< PageResult< Item>>(){});
        return items;

    }
}
