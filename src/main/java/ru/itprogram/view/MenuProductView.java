package ru.itprogram.view;

import ru.itprogram.provider.CatalogProvider;

public class MenuProductView {
    public static void productPrint() {
        System.out.println("Для возврата в предыдущие меню введите 0 и нажмите Enter");
        new CatalogProvider().print();
    }

    public static void addProductPrint() {
        System.out.println("Для добавления товара в корзину введите id товара и нажмите Enter");
    }
}
