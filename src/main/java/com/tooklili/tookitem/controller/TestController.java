package com.tooklili.tookitem.controller;


import com.tooklili.tookitem.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: shuaiding
 * @Date: 2018/6/15 11:07
 * @Description:
 */
@Controller
public class TestController {


    @RequestMapping("/test")
    public String test(Model model){
        Item item = new Item();
        item.setTitle("测试<div>");


        model.addAttribute("item",item);
        model.addAttribute("htmlcontent","<div>这里包含html脚本</div>");
        return "test/test";
    }
}
