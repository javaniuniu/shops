package com.javaniuniu.shops.controller;

import com.javaniuniu.shops.common.web.JsonResult;
import com.javaniuniu.shops.model.Admin;
import com.javaniuniu.shops.model.News;
import com.javaniuniu.shops.service.AdminService;
import com.javaniuniu.shops.service.NewsService;
import com.javaniuniu.shops.service.OrderService;
import com.javaniuniu.shops.util.AdminUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 7:36 PM
 */
@Controller
@Slf4j
//TODO Controller 使用restController 重写
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    OrderService orderService;

    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {
        return "admin/adminReg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String doReg(Admin admin) {
        adminService.save(admin);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpSession session) {
        return "admin/adminLogin";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testIndex() {
        return "admin/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(Admin admin, HttpSession session) {
        if (adminService.checkLogin(admin)) {
            AdminUtil.saveAdminToSession(session, adminService.findByUsernameAndPassword(admin.getUsername(), admin.getPassword()));
            log.debug("管理员[{}]登陆成功", admin.getUsername());
            return "redirect:/admin/product";
        }
        return "redirect:/admin/login?errorPwd=true";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String doLogout(HttpSession session) {
        AdminUtil.deleteAdminFromSession(session);
        return "redirect:/";
    }

    @RequestMapping(value = "/news/delete/{id}")
    @ResponseBody
    public JsonResult newsDelete(@PathVariable("id") Integer id) {
        newsService.delNews(id);
        JsonResult result = new JsonResult();
        result.setToSuccess();
        return result;
    }

    @RequestMapping(value = "/news/{id}")
    public ModelAndView newView(@PathVariable("id") Integer id, ModelAndView model) {
        News news = newsService.findById(id);
        model.addObject("news", news);
        model.setViewName("admin/news/newsDetail");
        return model;
    }

    @RequestMapping(value = "/news/new", method = RequestMethod.GET)
    public String newsAdd(HttpSession session) {
        if (AdminUtil.getAdminFromSession(session) == null)
            return "redirect:/admin/login?error=true";
        return "admin/news/newsAdd";
    }

    @RequestMapping(value = "/news/add", method = RequestMethod.POST)
    public String newsAdd(News news, HttpSession session) {
        news.setInputUser(AdminUtil.getAdminFromSession(session));
        news.setCreateTime(new Date());
        newsService.addNews(news);
        return "redirect:/admin/news";
    }
}
