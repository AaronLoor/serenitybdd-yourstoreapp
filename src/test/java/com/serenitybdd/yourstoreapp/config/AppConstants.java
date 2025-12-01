package com.serenitybdd.yourstoreapp.config;

public class AppConstants {

    private AppConstants() {}

    public static class Timeouts {
        public static final int SHORT = 10;
    }

    public static class ProductsNames {
        public static final String PRODUCT_MACKBOOK = "MacBook";
        public static final String PRODUCT_IPHONE = "iPhone";
    }

    public static class CustomerData {
        public static final String FIRST_NAME = "Juan";
        public static final String LAST_NAME = "Perez";
        public static final String EMAIL = "juan.perez@test.com";
        public static final String PHONE = "123456789";

        public static final String ADDRESS = "Av. Amazonas y Naciones Unidas";
        public static final String CITY = "Quito";
        public static final String POST_CODE = "01492";

        public static final String COUNTRY = "United Kingdom";
        public static final String REGION = "Aberdeen";
    }

    public static class Messages {
        public static final String MSG_ORDER_SUCCESS = "Your order has been placed!";
    }
}