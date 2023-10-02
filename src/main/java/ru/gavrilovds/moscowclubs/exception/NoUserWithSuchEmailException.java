package ru.gavrilovds.moscowclubs.exception;

public class NoUserWithSuchEmailException extends Exception {
    public NoUserWithSuchEmailException(String message) {
        super(message);
    }
}
