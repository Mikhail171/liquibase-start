package ru.kismi.springliquibasestart.error.exception;

public class MaxPriceExceededException extends RuntimeException {

    public MaxPriceExceededException(String message) {
        super(message);
    }
}