package ru.itprogram.service;

import ru.itprogram.entity.dao.User;
import ru.itprogram.entity.dto.UserDto;
import ru.itprogram.repository.UserRepository;
import ru.itprogram.service.converter.user.UserDtoToUser;
import ru.itprogram.service.converter.user.UserToUserDto;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Service<UserDto> {
    @Override
    public List<UserDto> getAll() {
        List<User> users = new UserRepository().getAllEntity();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            userDtoList.add(new UserToUserDto().conversion(user));
        }
        return userDtoList;
    }

    @Override
    public void add(UserDto userDto) {
        new UserRepository().saveEntity(new UserDtoToUser().conversion(userDto));
    }
}
