package ru.itprogram.service.converter.user;

import ru.itprogram.entity.dao.User;
import ru.itprogram.entity.dto.UserDto;
import ru.itprogram.repository.UserRepository;
import ru.itprogram.service.converter.Converter;

import java.util.List;

public class UserDtoToUser implements Converter<User, UserDto> {
    @Override
    public User conversion(UserDto userDto) {
        User user = new User();
        user.setId(getIdUser(userDto));
        user.setAdministrator(userDto.isAdministrator());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setDateTimeRegistration(userDto.getDateTimeRegistration());
        return user;
    }

    private int getIdUser(UserDto userDto) {
        List<User> users = new UserRepository().getAllEntity();
        return getId(users, userDto);
    }

    private int getId(List<User> users, UserDto userDto) {
        int tempId = 0;
        for (User user : users){
            if (user.getName().equals(userDto.getName())
                    && user.getPassword().equals(userDto.getPassword())) {
                tempId = user.getId();
            }
        }
        return tempId;
    }
}
