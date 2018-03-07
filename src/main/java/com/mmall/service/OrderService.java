package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

public interface OrderService {

    public ServerResponse pay(Long orderNo, Integer userId, String path);

    public ServerResponse aliCallback(Map<String, String> params);

    public ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);
}
