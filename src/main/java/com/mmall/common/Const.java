package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    public interface Role {
        Integer ROLE_CUSTOMER = 0; //普通用户
        Integer ROLE_ADMIN = 1; //管理员
    }

    public interface Cart {
        Integer CHECKED = 1; //已勾选
        Integer UNCHECKED = 0; //未勾选

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public enum ProductStatusEnum{
        ON_SALE(1, "在线");
        private String value;
        private Integer code;
        ProductStatusEnum(Integer code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Integer getCode() {
            return code;
        }
    }
}
