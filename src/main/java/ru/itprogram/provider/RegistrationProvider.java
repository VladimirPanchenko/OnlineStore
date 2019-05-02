package ru.itprogram.provider;

import ru.itprogram.entity.dto.UserDto;
import ru.itprogram.exceptions.UserNameIsRepeatedException;
import ru.itprogram.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

public class RegistrationProvider {
    public static final String USER_NAME_IS_REPEATED = "Такое имя не допустимо";
    private List<UserDto> userDtoList;

    public RegistrationProvider() {
        userDtoList = new UserService().getAll();
    }

    public void addUser(String name, String email, String phone, String password) throws UserNameIsRepeatedException {
        if (!checkUserName(name)) {
            new UserService()
                    .add(new UserDto(0, false, name, email, phone, password, LocalDateTime.now()));
        }
    }

    private boolean checkUserName(String name) throws UserNameIsRepeatedException {
        boolean isRepeated = false;
        for (UserDto userDto : userDtoList) {
            if (userDto.getName().equals(name)) {
                isRepeated = true;
                throw new UserNameIsRepeatedException(USER_NAME_IS_REPEATED);
            }
        }
        return isRepeated;
    }
}
