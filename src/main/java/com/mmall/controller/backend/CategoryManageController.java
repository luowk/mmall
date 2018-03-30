package com.mmall.controller.backend;

import com.mmall.common.ServerResponse;
import com.mmall.service.CategoryService;
import com.mmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addCategory.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addCategory(String categoryName, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        return categoryService.addCategory(categoryName, parentId);
    }

    @RequestMapping(value = "/setCategoryName.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setCategoryName(Integer categoryId, String categoryName) {
        return categoryService.updateCategoryName(categoryId, categoryName);
    }

    @RequestMapping(value = "/getChildrenParallelCategory.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        //查询子节点的category信息，并且不递归，保持平级
        return categoryService.getChildrenParallelCategory(categoryId);
    }

    @RequestMapping(value = "/getDeepCategory.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getDeepCategory(@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        //查询当前结点ID和子节点的ID
        return categoryService.selectCategoryAndChildrenById(categoryId);
    }

}
