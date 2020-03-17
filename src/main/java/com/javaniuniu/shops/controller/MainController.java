package com.javaniuniu.shops.controller;

import com.javaniuniu.shops.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 5:15 PM
 */
@Slf4j
@Controller
public class MainController {

    @Autowired
    ProductService productService;

    @GetMapping("/index")
    public ModelAndView index(ModelAndView model) {
        model = new ModelAndView("index");
        model.addObject("newProductList", productService.findNew());
        model.addObject("popProductList", productService.findPop());
        model.addObject("productList", productService.findAll());
        model.addObject("productTypeList", productService.findType());
        return model;
    }


    /**
     * 页面访问测试方法
     *
     * @return
     */
    @GetMapping("/sayHello")
    @ResponseBody
    public String aa() {
        return "hello";
    }
}
