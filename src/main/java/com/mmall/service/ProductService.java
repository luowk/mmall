package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

public interface ProductService {

    public ServerResponse saveOrUpdateProduct(Product product);

    public ServerResponse setSaleStatus(Integer productId, Integer status);

    public ServerResponse<ProductDetailVo> manageProductDetail(Integer productId)
}
