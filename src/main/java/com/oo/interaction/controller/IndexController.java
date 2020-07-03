package com.oo.interaction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页，提供描述信息和测试方法
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("newWorld","WELCOME TO NEW WORLD!!!");
        return "index";
    }
}
