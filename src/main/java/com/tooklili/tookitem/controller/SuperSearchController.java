package com.tooklili.tookitem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tooklili.tookitem.config.ServerUrlConfig;
import com.tooklili.tookitem.model.Item;
import com.tooklili.tookitem.model.TookHotKeyword;
import com.tooklili.tookitem.result.PageResult;
import com.tooklili.tookitem.service.TookItemService;
import com.tooklili.tookitem.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 此处，超级搜接口改到淘宝客接口
 * @author shuai.ding
 * @date 2018年06月04日 下午10:45
 */
@Controller
public class SuperSearchController {

    @Autowired
    private TookItemService tookItemService;

    @Autowired
    private ServerUrlConfig serverUrlConfig;

    /**
     * 到超级搜索页面
     * @return
     */
    @RequestMapping("to_super_search")
    public String toSuperSearch(Integer userFlag, Model model){
        //查询热门关键字
        List<TookHotKeyword> tookHotKeywords = tookItemService.getRandomKeywords(10);
        model.addAttribute("tookHotKeywords",tookHotKeywords);

        model.addAttribute("userFlag",userFlag);

        return "to_super_search";
    }


    /**
     * 超级搜页面
     * @param model
     * @param title
     * @return
     */
    @RequestMapping("super_search")
    public String superSearch(Model model,String title,Integer status,Boolean hasHyq,Integer userFlag){
        //关键字
        model.addAttribute("title",title);

        model.addAttribute("userFlag",userFlag);

        Map<String,String> params = new HashMap<>();
        //选中的条件
        if(status != null){
            model.addAttribute("status",status);
        }

        //只选择有优惠券的商品
        if(hasHyq !=null && hasHyq==true){
            model.addAttribute("hasHyq",hasHyq);
        }

        //查询商品
        PageResult<Item> result = super_search_list(title,status,hasHyq,1,20);
        model.addAttribute("items",result.getData());

        return "super_search";
    }


    /**
     *
     * @param title    标题
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("super_search_list")
    @ResponseBody
    public PageResult<Item> super_search_list(String title,Integer status,Boolean hasHyq,Integer currentPage,Integer pageSize){

        Map<String,String> params = new HashMap<>();
        //选中的条件
        if(status != null){
            switch (status){
                case 0:  //综合
                    break;
                case 1: //人气
                    params.put("sort","tk_total_sales_des");
                    break;
                case 2:  //销量
                    params.put("sort","total_sales_des");
                    break;
                case 3:  //价格
                    params.put("sort","price_des");
                    break;
                default:
                    break;
            }
        }

        //只选择有优惠券的商品
        if(hasHyq !=null && hasHyq==true){
            params.put("hasCoupon","true");
        }
        params.put("q",title);
        params.put("pageNo",currentPage.toString());
        params.put("pageSize",pageSize.toString());

        String content = HttpClientUtils.doPost(serverUrlConfig.getTbkApiItemUrl(),params);

        PageResult<Item> result = JSON.parseObject(content,new TypeReference< PageResult< Item>>(){});

        return result;
    }

}
