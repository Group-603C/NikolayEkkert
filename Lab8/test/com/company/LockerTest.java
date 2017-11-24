package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class LockerTest {

    private Locker instance = new Locker(5);


    @Test
    public void verification() throws LockerException {

        instance.unlock();
        instance.set(154);
        assertEquals(154, instance.get());

        instance.lock();
        try {
            instance.set(666);
            fail("LockerException but value changed.");
        }
        catch (LockerException e) {
            assertEquals(154, instance.get());
        }

        instance.unlock();
        instance.set(777);
        assertEquals(777, instance.get());
    }
}