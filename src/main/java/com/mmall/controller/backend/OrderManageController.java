package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.OrderService;
import com.mmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/order")
public class OrderManageController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse orderList(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if (userService.checkAdminRole(user).isSuccess()) {
            return orderService.manageList(pageNum, pageSize);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse orderDetail(HttpSession session, Long orderNo) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if (userService.checkAdminRole(user).isSuccess()) {
            return orderService.manageDetail(orderNo);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse orderSearch(HttpSession session, Long orderNo,
                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if (userService.checkAdminRole(user).isSuccess()) {
            return orderService.manageSearch(orderNo, pageNum, pageSize);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping(value = "/send_goods", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse sendGoods(HttpSession session, Long orderNo) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        if (userService.checkAdminRole(user).isSuccess()) {
            return orderService.manageSendGoods(orderNo);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }



}
