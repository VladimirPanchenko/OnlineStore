package ru.itprogram.view;

public class MenuView {
    public static void welcomePrint() {
        System.out.println("Добро пожаловать!\n"
                + "Для входа в аккаунт введите 1 и нажмите Enter\n"
                + "Для регистрации введите 2 и нажмите Enter");
    }

    public static void cancel() {
        System.out.println("Тчо бы начать сначала введите 0 и нажмите Enter");
    }
}
