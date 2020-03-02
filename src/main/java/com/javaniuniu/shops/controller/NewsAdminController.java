package com.javaniuniu.shops.controller;

import com.javaniuniu.shops.common.Page;
import com.javaniuniu.shops.common.web.JsonResult;
import com.javaniuniu.shops.model.News;
import com.javaniuniu.shops.model.Product;
import com.javaniuniu.shops.model.UserAddress;
import com.javaniuniu.shops.service.NewsService;
import com.javaniuniu.shops.util.AdminUtil;
import com.javaniuniu.shops.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 5:17 PM
 */
@Controller
@RequestMapping("/admin/news")
public class NewsAdminController {

    private static final Logger logger = LoggerFactory.getLogger(NewsAdminController.class);
    @Autowired
    NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, HttpServletRequest request) {
        Page<News> page = new Page<News>(request);
        newsService.findNews(page);
        model.addObject("page",page);
        model.setViewName("admin/news/newsAdmin");
        return model;
    }

    // TODO 查看News
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewNews(@PathVariable Integer id, ModelAndView model, HttpServletRequest request) {
        News news = newsService.findById(id);
        model.addObject("news", news);
        model.setViewName("news/newsDetail");
        return model;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView model, @PathVariable Integer id) {
        News news = newsService.findById(id);
        model.addObject("news", news);
        model.setViewName("/admin/news/newsEdit");
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView doEdit(ModelAndView model, News news, HttpSession session) {
        news.setInputUser(AdminUtil.getAdminFromSession(session));
        newsService.addNews(news);
        model.setViewName("redirect:/admin/news");
        return model;
    }

}
