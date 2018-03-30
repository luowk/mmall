package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.math.BigDecimal;
import java.util.Map;

public interface OrderService {

    public ServerResponse pay(Long orderNo, Integer userId, String path);

    public ServerResponse aliCallback(Map<String, String> params);

    public ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    public ServerResponse createOrder(Integer userId, Integer shippingId);

    public ServerResponse cancelOrder(Integer userId, Long orderNo);

    public ServerResponse getOrderCartProduct(Integer userId);

    public ServerResponse getOrderDetail(Integer userId, Long orderNo);

    public ServerResponse getOrderList(Integer userId, Integer pageNum, Integer pageSize);

    public Boolean checkAlipayCallbackData(String orderNo, BigDecimal totalAmount, String sellerId);

    public ServerResponse manageList(Integer pageNum, Integer pageSize);

    public ServerResponse manageDetail(Long orderNo);

    public ServerResponse manageSearch(Long orderNo, Integer pageNum, Integer pageSize);

    public ServerResponse manageSendGoods(Long orderNo);

    public void closeOrder(Integer hour);
}
