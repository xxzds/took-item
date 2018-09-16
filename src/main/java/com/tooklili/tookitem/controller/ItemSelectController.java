package com.tooklili.tookitem.controller;

import com.tooklili.tookitem.model.TookItemSelect;
import com.tooklili.tookitem.result.PageResult;
import com.tooklili.tookitem.service.TookItemSelectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 人工选择的商品 控制器
 * @author shuai.ding
 * @date 2018年06月24日 下午5:58
 */
@Controller
public class ItemSelectController {

    @Autowired
    private TookItemSelectService tookItemSelectService;



    @RequestMapping("/item/select")
    public String itemSelect(Model model, String cateName){
        if(StringUtils.isEmpty(cateName)){
            model.addAttribute("error","分类名称不能为空");
            return "error";
        }
        model.addAttribute("cateName",cateName);
        return "select/item";
    }


    @RequestMapping("/item/select/list")
    public String itemList(Model model,String cateName,Integer currentPage, Integer pageSize){

        PageResult<TookItemSelect> result = tookItemSelectService.findItem(cateName,currentPage,pageSize);

        if(result.getData().size() == 0){
            return "empty";
        }

        model.addAttribute("items",result.getData());
        return "select/item_list";
    }


}
