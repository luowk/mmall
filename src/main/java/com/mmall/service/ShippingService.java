package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

public interface ShippingService {

    public ServerResponse add(Integer userId, Shipping shipping);

    public ServerResponse delete(Integer userId, Integer shippingId);

    public ServerResponse update(Integer userId, Shipping shipping);

    public ServerResponse detail(Integer userId, Integer shippingId);

    public ServerResponse list(Integer userId, Integer pageNum, Integer pageSize);
}
