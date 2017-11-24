package com.company;

public class Locker {

    private boolean isLock = false;
    private int value;


    public Locker(int value) {
        this.value = value;
    }

    void set(int value) throws LockerException {

        if (!this.isLock) {
            throw new LockerException();
        }

        this.value = value;
    }

    int get() {
        return this.value;
    }

    void lock() {
        this.isLock = false;
    }

    void unlock() {
        this.isLock = true;
    }
}
