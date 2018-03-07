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

    public enum OrderStatusEnum {
        CANCELD(0, "已取消"),
        NO_PAY(10, "未支付"),
        PAID(20, "已付款"),
        SHIPPED(40, "已发货"),
        ORDER_SUCCESS(50, "订单完成"),
        ORDER_CLOSE(60, "订单关闭")
        ;

        private String value;
        private Integer code;

        OrderStatusEnum(Integer code, String value) {
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

    public interface AlipayCallback {
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_CLOSED = "TRADE_CLOSED";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";
        String TRADE_STATUS_TRADE_FINISHED = "TRADE_FINISHED";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }

    public enum PayPlatformEnum {
        ALIPAY(1, "支付宝"),
        ;
        private String value;
        private Integer code;

        PayPlatformEnum(Integer code, String value) {
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
