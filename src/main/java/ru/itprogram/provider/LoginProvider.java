package ru.itprogram.provider;

import ru.itprogram.entity.dto.UserDto;
import ru.itprogram.exceptions.UserNotFoundException;
import ru.itprogram.service.UserService;

import java.util.List;

public class LoginProvider {
    public static final String USER_NOT_FOUND = "Ошибка! Введены неверные данные!";
    private List<UserDto> userDtoList;
    private UserDto currentUserDto;
    private String name;
    private String password;

    public LoginProvider(String name, String password) {
        this.name = name;
        this.password = password;
        userDtoList = new UserService().getAll();
    }

    public UserDto entrance() throws UserNotFoundException {
        currentUserDto = findUserDto();
        if (!checkUserDto(currentUserDto)) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        return currentUserDto;
    }

    private boolean checkUserDto(UserDto userDto) {
        boolean checkUser = false;
        if (userDto != null) {
            checkUser = true;
        }
        return checkUser;
    }

    private UserDto findUserDto() {
        UserDto userDto = null;
        for (UserDto findUserDto : userDtoList) {
            if (findUserDto.getName().equals(name) && findUserDto.getPassword().equals(password)) {
                userDto = findUserDto;
            }
        }
        return userDto;
    }

    private boolean checkName(String name) {
        boolean nameUser = false;
        for (UserDto userDto : userDtoList) {
            if (userDto.getName().equals(name)) {
                nameUser = true;
            }
        }
        return nameUser;
    }
}
