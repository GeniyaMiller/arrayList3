package com.skypro.arraylist.exceptions;

public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException() {
    }

    public ArrayIsFullException(String e) {
    }

    public ArrayIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIsFullException(Throwable cause) {
        super(cause);
    }

    public ArrayIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
