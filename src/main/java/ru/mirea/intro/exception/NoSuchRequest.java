package ru.mirea.intro.exception;

public class NoSuchRequest extends Exception {
    public NoSuchRequest() {
        super("There is no request");
    }
}
