package ru.gavrilovds.moscowclubs.exception;

public class NoClubWithSuchNameException extends Exception{
    public NoClubWithSuchNameException(String message) {
        super(message);
    }
}
