package ru.itprogram.exceptions;

public class UserNameIsRepeatedException extends Exception {
    public UserNameIsRepeatedException(String message) {
        super(message);
    }
}
