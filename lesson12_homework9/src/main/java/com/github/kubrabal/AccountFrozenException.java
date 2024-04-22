package com.github.kubrabal;

public class AccountFrozenException extends Exception {
    public AccountFrozenException(String message) {
        super(message);
    }
}
