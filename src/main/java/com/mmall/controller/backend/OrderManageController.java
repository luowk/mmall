package com.mmall.controller.backend;

import com.mmall.common.ServerResponse;
import com.mmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage/order")
public class OrderManageController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse orderList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return orderService.manageList(pageNum, pageSize);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse orderDetail(Long orderNo) {
        return orderService.manageDetail(orderNo);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse orderSearch(Long orderNo,
                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return orderService.manageSearch(orderNo, pageNum, pageSize);
    }

    @RequestMapping(value = "/send_goods", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse sendGoods(Long orderNo) {
        return orderService.manageSendGoods(orderNo);
    }



}
