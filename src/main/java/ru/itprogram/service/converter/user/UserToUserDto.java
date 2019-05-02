package ru.itprogram.service.converter.user;

import ru.itprogram.entity.dao.User;
import ru.itprogram.entity.dto.UserDto;
import ru.itprogram.service.converter.Converter;

public class UserToUserDto implements Converter<UserDto, User> {
    @Override
    public UserDto conversion(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAdministrator(user.isAdministrator());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setPassword(user.getPassword());
        userDto.setDateTimeRegistration(user.getDateTimeRegistration());
        return userDto;
    }
}
