package com.jpub.ch04.ch04Ex.controller;

import com.jpub.ch04.ch04Ex.service.InMemoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private InMemoryProductService inMemoryProductService;

    @RequestMapping(value = "/th")
    public String templatePage(Model m){
        m.addAttribute("message", "boot template");
        return "th";
    }

    @RequestMapping(value = "/th2")
    public String templatePage2(Model m){
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("color", "red");
        pageMap.put("name", "jam");
        pageMap.put("price", "3000");
        m.addAttribute("product", pageMap);
        return "th2";
    }

    @RequestMapping(value = "/th3")
    public String templatePage3(Model m){
        m.addAttribute("products", inMemoryProductService.getProductList());
        return "th3";
    }
}
