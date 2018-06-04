package com.tooklili.tookitem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shuai.ding
 * @date 2018年06月04日 下午10:45
 */
@Controller
public class SuperSearchController {

    @RequestMapping("to_super_search")
    public String toSuperSearch(){
        return "to_super_search";
    }


    @RequestMapping("super_search")
    public String superSearch(){
        return "super_search";
    }

}
