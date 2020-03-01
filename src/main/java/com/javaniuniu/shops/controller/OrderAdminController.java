package com.javaniuniu.shops.controller;

import com.javaniuniu.shops.common.Constants;
import com.javaniuniu.shops.common.Page;
import com.javaniuniu.shops.common.web.JsonResult;
import com.javaniuniu.shops.model.Order;
import com.javaniuniu.shops.service.OrderService;
import com.javaniuniu.shops.service.UserAddressService;
import com.javaniuniu.shops.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 8:13 PM
 */
@Controller
@RequestMapping("/admin/order")
public class OrderAdminController {
    private static final Logger logger = LoggerFactory.getLogger(OrderAdminController.class);

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserAddressService userAddressService;
    /**
     * 订单管理
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String adminList(Model model, HttpServletRequest request) {
        Page<Order> page = new Page<Order>(request);
        orderService.findOrders(page);
        model.addAttribute("page", page);
        return "admin/order/orderAdmin";
    }
    /**
     * 订单删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        JsonResult result = new JsonResult();
        result.setToSuccess();
        return result;
    }
    /**
     * 订单取消
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult cancel(@PathVariable(value = "id") Integer orderId) {
        orderService.updateOrderStatus(orderId, Constants.OrderStatus.DELETED);
        JsonResult result = new JsonResult();
        result.setToSuccess();
        return result;
    }


    /**
     * 订单发货
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/ship/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult ship(@PathVariable(value = "id") Integer orderId, HttpSession session) {
        orderService.updateOrderStatus(orderId, Constants.OrderStatus.SHIPPED);

        JsonResult result = new JsonResult();
        result.setToSuccess();
        return result;
    }





}
