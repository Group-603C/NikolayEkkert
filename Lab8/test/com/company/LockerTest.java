package com.company;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LockerTest {

    private Locker instance = new Locker();

    @Test
    public void lockContainer() throws LockerException {

        instance.lock();
        try {

            instance.set(154);
        }
        catch (LockerException le){
            Assert.assertNotEquals("", le.getMessage());
        }

        assertEquals("", Integer.MIN_VALUE, instance.get());
    }

    @Test
    public void unlockContainer() throws LockerException{

        instance.unlock();
        try {

            instance.set(154);
        }
        catch (LockerException le){

            Assert.assertNotEquals("", le.getMessage());
        }

        assertEquals("", 154, instance.get());
    }

}