package ru.itprogram.view;

public class MenuLoginView {
    public static void welcomePrint() {
        System.out.println("Для входа введите логин и нажмите Enter\n" +
                " затем введите пароль и нажмите Enter");
    }

    public static void start(String name) {
        System.out.println("Добро пожаловать " + name);
    }

    public static void subMenu() {
        System.out.println("Для вывода товаров введите 1 и нажмите Enter\n"
                + "Для вывода истории введите 2 и нажмите Enter\n"
                + "Для вывода содержимого корзины введите 3 и нажмите Enter");
    }
}
