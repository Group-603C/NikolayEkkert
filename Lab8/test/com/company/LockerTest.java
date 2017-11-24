package com.company;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LockerTest {

    private Locker instance = new Locker(5);


    @Test
    public void lockContainer() {

        try {
            instance.set(154);
            Assert.fail("Exception");
        }
        catch (LockerException e) {
        }

        assertEquals("Lock Container", 5, instance.get());
    }
}