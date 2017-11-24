package com.company;

public class Main {

    public static void main(String[] args) {

        Locker locker = new Locker(1);

        locker.get();

        locker.unlock();
        try {
            locker.set(3);
        }
        catch (LockerException e) {
            System.out.println(Integer.MIN_VALUE);
        }


    }
}
