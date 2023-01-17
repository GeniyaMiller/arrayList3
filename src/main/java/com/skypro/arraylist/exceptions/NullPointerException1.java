package com.skypro.arraylist.exceptions;

public class NullPointerException1 extends RuntimeException {
    public NullPointerException1() {
    }

    public NullPointerException1(String message) {
        super(message);
    }

    public NullPointerException1(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPointerException1(Throwable cause) {
        super(cause);
    }

    public NullPointerException1(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
