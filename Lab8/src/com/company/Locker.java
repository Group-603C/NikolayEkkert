package com.company;

public class Locker {

    private boolean isLock;
    private int value;


    public Locker(int value) {

        this.isLock = false;
        this.value = value;
    }

    public void set(int value) throws LockerException {

        if (this.isLock) {
            throw new LockerException();
        }
        this.value = value;
    }

    public int get() {
        return this.value;
    }

    public void lock() {
        this.isLock = true;
    }

    public void unlock() {
        this.isLock = false;
    }
}