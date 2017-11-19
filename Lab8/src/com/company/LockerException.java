package com.company;

public class LockerException extends Exception {

    public LockerException(){
        super("The container is locked!");
    }

    public LockerException(String message){
        super(message);
    }
}
