package ru.gavrilovds.moscowclubs.exception;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String message) {
        super(message);
    }
}
