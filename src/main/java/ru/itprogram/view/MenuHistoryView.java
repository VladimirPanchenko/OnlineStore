package ru.itprogram.view;

import ru.itprogram.entity.dto.UserDto;
import ru.itprogram.provider.PurchaseHistory;

public class MenuHistoryView {
    public static void HistoryPrint(UserDto userDto){
        System.out.println("История ваших покупок: ");
        new PurchaseHistory(userDto).printAllHistory();
    }
}
