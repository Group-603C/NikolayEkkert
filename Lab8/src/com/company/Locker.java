package com.company;

public class Locker {

    private boolean isLock;
    private int value;


    public Locker() {

        unlock();
        this.value = Integer.MIN_VALUE;
    }

    void set(int value) throws LockerException {

        if (isLock == true) {
            this.value = value;
        }
        else {
            throw new LockerException();
        }
    }

    int get() {
        return value;
    }

    void lock() {
        this.isLock = false;
    }

    void unlock() {
        this.isLock = true;
    }
}
