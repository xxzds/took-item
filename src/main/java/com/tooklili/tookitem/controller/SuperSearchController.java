package com.tooklili.tookitem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tooklili.tookitem.model.Item;
import com.tooklili.tookitem.result.PageResult;
import com.tooklili.tookitem.util.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuai.ding
 * @date 2018年06月04日 下午10:45
 */
@Controller
public class SuperSearchController {

    /**
     * 到超级搜索页面
     * @return
     */
    @RequestMapping("to_super_search")
    public String toSuperSearch(){
        return "to_super_search";
    }


    /**
     * 超级搜页面
     * @param model
     * @param title
     * @return
     */
    @RequestMapping("super_search")
    public String superSearch(Model model,String title){
        //关键字
        model.addAttribute("title",title);


        //查询商品
        String url = "http://www.tooklili.com/tookApp/superSearchItems";
        Map<String,String> params = new HashMap<>();
        params.put("q",title);
        String content = HttpClientUtils.doPost(url,params);

        PageResult<Item> result = JSON.parseObject(content,new TypeReference< PageResult< Item>>(){});
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
    public PageResult<Item> super_search_list(String title,Integer currentPage,Integer pageSize){
        String url = "http://www.tooklili.com/tookApp/superSearchItems";
        Map<String,String> params = new HashMap<>();
        params.put("q",title);
        params.put("currentPage",currentPage.toString());
        params.put("pageSize",pageSize.toString());

        String content = HttpClientUtils.doPost(url,params);

        PageResult<Item> result = JSON.parseObject(content,new TypeReference< PageResult< Item>>(){});

        return result;
    }

}
