package ru.itprogram.entity.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserDto {
    private int id;
    private boolean administrator;
    private String name;
    private String email;
    private String phone;
    private String password;
    private LocalDateTime dateTimeRegistration;

    public UserDto() {

    }

    public UserDto(int id, boolean administrator, String name, String email, String phone,
                   String password, LocalDateTime dateTimeRegistration) {
        this.id = id;
        this.administrator = administrator;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.dateTimeRegistration = dateTimeRegistration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateTimeRegistration() {
        return dateTimeRegistration;
    }

    public void setDateTimeRegistration(LocalDateTime dateTimeRegistration) {
        this.dateTimeRegistration = dateTimeRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id &&
                administrator == userDto.administrator &&
                Objects.equals(name, userDto.name) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(phone, userDto.phone) &&
                Objects.equals(password, userDto.password) &&
                Objects.equals(dateTimeRegistration, userDto.dateTimeRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, administrator, name, email, phone, password, dateTimeRegistration);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", administrator=" + administrator +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", dateTimeRegistration=" + dateTimeRegistration +
                '}';
    }
}
