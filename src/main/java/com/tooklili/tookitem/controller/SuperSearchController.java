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
 * @author shuai.ding
 * @date 2018年06月04日 下午10:45
 */
@Controller
public class SuperSearchController {

    @Autowired
    private TookItemService tookItemService;

    /**
     * 到超级搜索页面
     * @return
     */
    @RequestMapping("to_super_search")
    public String toSuperSearch(Model model){
        //查询热门关键字
        List<TookHotKeyword> tookHotKeywords = tookItemService.getRandomKeywords(10);
        model.addAttribute("tookHotKeywords",tookHotKeywords);

        return "to_super_search";
    }


    /**
     * 超级搜页面
     * @param model
     * @param title
     * @return
     */
    @RequestMapping("super_search")
    public String superSearch(Model model,String title,Integer status,Boolean hasHyq){
        //关键字
        model.addAttribute("title",title);

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
                    params.put("queryType","2");
                    break;
                case 2:  //销量
                    params.put("sortType","9");
                    break;
                case 3:  //价格
                    params.put("sortType","3");
                    break;
                default:
                    break;
            }
        }

        //只选择有优惠券的商品
        if(hasHyq !=null && hasHyq==true){
            params.put("dpyhq","1");
        }
        params.put("q",title);
        params.put("currentPage",currentPage.toString());
        params.put("pageSize",pageSize.toString());

        String content = HttpClientUtils.doPost(ServerUrlConfig.superSearchItemsUrl,params);

        PageResult<Item> result = JSON.parseObject(content,new TypeReference< PageResult< Item>>(){});

        return result;
    }

}
