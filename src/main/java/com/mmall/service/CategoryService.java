package com.mmall.service;

import com.mmall.common.ServerResponse;

public interface CategoryService {

    public ServerResponse addCategory(String categoryName, Integer parentId);

    public ServerResponse updateCategoryName(Integer categoryId, String categoryName);
}
