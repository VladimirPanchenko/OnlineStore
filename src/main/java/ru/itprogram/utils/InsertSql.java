package ru.itprogram.utils;

public class InsertSql {
    public static final String INSERT_USER =
            "INSERT INTO public.user (administrator, \"name\", email, phone, \"password\") " +
                    "VALUES (?, ?, ?, ?, ?);";
    public static final String INSERT_PRODUCT =
            "INSERT INTO public.product(brand_id, product_type_id, description,quantity," +
                    " warranty, available, price, promo_cod_id" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String INSERT_BRAND = "INSERT INTO public.brand (name) VALUES (?);";
    public static final String INSERT_CART = "INSERT INTO public.cart (user_id, product_id, paid" +
            ", is_closed) VALUES (?, ?, ?, ?);";
    public static final String INSERT_PRODUCT_TYPE = "INSERT INTO public.product_type (\"type\")" +
            " VALUES (?);";
    public static final String INSERT_PROMO_CODE = "INSERT INTO public.promo_cod (code, discount)" +
            " VALUES (?, ?);";
}
