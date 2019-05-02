package ru.itprogram.view;

import ru.itprogram.entity.dto.OrderDto;
import ru.itprogram.provider.BasketProvider;

public class MenuBasketView {
    public static void basketPrint(BasketProvider basketProvider) {
        System.out.println("Ваша корзина:");
        for (OrderDto orderDto : basketProvider.getOrderDtoList()){
            System.out.println("ID продукта: [" + orderDto.getProductDto().getId()
                    + "] Бренд: [" + orderDto.getProductDto().getBrandDto().getName()
                    + "] Тип продукта: [" + orderDto.getProductDto()
                    .getProductTypeDto().getType()
                    + "] Описание: [" + orderDto.getProductDto().getDescription()
                    + "] Гарантия: [" + orderDto.getProductDto().getWarranty()
                    + "] Цена: [" + orderDto.getProductDto().getPrice()
                    + "] Оплачен ли товар: [" + orderDto.isPaid()
                    + "] Дата покупки: [" + orderDto.getOrderDate());
        }
    }

    public static void basketSubMenuPrint() {
        System.out.println("Для выхода из корзины введите -1 и нажмите Enter\n"
                + "Для покупки введите 0 и нажмите Enter\n"
                + "Для редактирования товаров в корзине введите 3 и нажмите Enter");
    }

    public static void removeProduct() {
        System.out.println("Для удаления товара из корзины введите его id и нажмите Enter"
                + "Для выхода из режима удаления введите 0 и нажмите Enter");
    }

    public static void thanks() {
        System.out.println("Спасибо за покупку!");
    }

    public static void totalPricePrint(double price) {
        System.out.println("Общая стоимость вашей покупки " + price);
    }
}
