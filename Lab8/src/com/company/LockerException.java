package com.company;

public class LockerException extends Exception {

    public LockerException() {
        super("The container is locked!");
    }
}
