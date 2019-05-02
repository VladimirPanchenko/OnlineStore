package ru.itprogram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itprogram.entity.dto.UserDto;
import ru.itprogram.exceptions.UserNameIsRepeatedException;
import ru.itprogram.exceptions.UserNotFoundException;
import ru.itprogram.provider.BasketProvider;
import ru.itprogram.provider.LoginProvider;
import ru.itprogram.provider.RegistrationProvider;
import ru.itprogram.utils.ReadProductInFile;
import ru.itprogram.view.*;

import java.util.Scanner;

public class App {
    public static final String ERROR_COMMAND = "Вы ввели невеную команду!";
    protected static Logger logger;
    private static UserDto userDto;
    private static BasketProvider basketProvider;

    public static void main(String[] args) {
        logger = LoggerFactory.getLogger(App.class);
        basketProvider = new BasketProvider();
        while (true) {
            if (userDto != null) {
                entrance(userDto.getName(), userDto.getPassword());
                MenuLoginView.start(userDto.getName());
            } else {
                start();
            }
        }
    }

    public static void start() {
        MenuView.welcomePrint();
        switch (insertInt()) {
            case 1:
                MenuLoginView.welcomePrint();
                entrance(insertString(), insertString());
                break;
            case 2:
                MenuRegistrationView.welcome();
                registration();
                break;
            default:
                System.out.println(ERROR_COMMAND);
                break;
        }
    }

    public static void entrance(String name, String password) {
        try {
            LoginProvider loginProvider = new LoginProvider(name, password);
                userDto = loginProvider.entrance();
        } catch (UserNotFoundException e) {
            logger.warn(e.getMessage(), e);
        }
        if (userDto != null) {
            if (!userDto.isAdministrator()) {
                store();
            } else {
                entranceAdmin();
            }
        }
    }

    public static void store() {
        MenuLoginView.subMenu();
        switch (insertInt()) {
            case 1:
                MenuProductView.productPrint();
                MenuProductView.addProductPrint();
                int temp = -1;
                while (temp != 0) {
                    temp = insertInt();
                    MenuProductView.productPrint();
                    MenuProductView.addProductPrint();
                    basketProvider.addProduct(temp, userDto);
                }
                break;
            case 2:
                MenuHistoryView.HistoryPrint(userDto);
                break;
            case 3:
                MenuBasketView.basketPrint(basketProvider);
                MenuBasketView.totalPricePrint(basketProvider.allPrice());
                basket();
                break;
            default:
                System.out.println(ERROR_COMMAND);
                break;
        }
    }

    public static void registration() {
        try {
            new RegistrationProvider()
                    .addUser(insertString(), insertString(), insertString(), insertString());
        } catch (UserNameIsRepeatedException e) {
            logger.warn(e.getMessage(), e);
        }
    }

    public static void entranceAdmin() {
        MenuAdministratorView.welcome();
        if (insertInt() == 1) {
            new ReadProductInFile().readFile(ReadProductInFile.PATH);
        } else {
            System.exit(0);
        }
    }

    public static void basket() {
        MenuBasketView.basketSubMenuPrint();
        switch (insertInt()) {
            case -1:
                break;
            case 0:
                basketProvider.buy();
                MenuBasketView.thanks();
                break;
            case 3:
                MenuBasketView.removeProduct();
                int temp = -1;
                while (temp != 0) {
                    MenuBasketView.basketPrint(basketProvider);
                    temp = insertInt();
                    basketProvider.RemoveProduct(temp, userDto);
                }
                break;
        }
    }

    public static int insertInt() {
        return new Scanner(System.in).nextInt();
    }

    public static String insertString() {
        return new Scanner(System.in).next();
    }
}
