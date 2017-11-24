package com.company;

public class Locker {

    private boolean isLock;
    private int value;


    public Locker(int value) {

        this.isLock = false;
        this.value = value;
    }

    void set(int value) throws LockerException {

        if (this.isLock) {
            throw new LockerException();
        }
        this.value = value;
    }

    int get() {
        return this.value;
    }

    void lock() {
        this.isLock = true;
    }

    void unlock() {
        this.isLock = false;
    }
}