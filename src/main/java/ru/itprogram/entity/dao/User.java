package ru.itprogram.entity.dao;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private int id;
    private boolean administrator;
    private String name;
    private String email;
    private String phone;
    private String password;
    private LocalDateTime dateTimeRegistration;

    public User() {

    }

    public User(int id, boolean administrator, String name, String email, String phone,
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
        User user = (User) o;
        return id == user.id &&
                administrator == user.administrator &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(password, user.password) &&
                Objects.equals(dateTimeRegistration, user.dateTimeRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, administrator, name, email, phone, password, dateTimeRegistration);
    }

    @Override
    public String toString() {
        return "User{" +
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
