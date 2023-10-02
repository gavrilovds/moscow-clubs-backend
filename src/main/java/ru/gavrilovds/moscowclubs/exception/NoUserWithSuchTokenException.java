package ru.gavrilovds.moscowclubs.exception;

public class NoUserWithSuchTokenException extends Exception{
    public NoUserWithSuchTokenException(String message) {
        super(message);
    }
}
