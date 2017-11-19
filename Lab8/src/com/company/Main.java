package com.company;

public class Main {

    public static void main(String[] args) {

        Locker instance = new Locker();
        try {
            instance.set(12);
        }
        catch (LockerException e) {

        }

        System.out.println(instance.get());
    }
}
