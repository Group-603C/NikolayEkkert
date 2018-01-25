package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BlockingQueueTest {

    @Test
    void takeNormal() {

        IBlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        Thread thread = new Thread(new Interaction(blockingQueue));
        blockingQueue.add(3);
        thread.start();
        int valueTake = blockingQueue.take();

        Assertions.assertEquals(valueTake, 3);
    }

    @Test
    void takeNull() {

        IBlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        Thread thread = new Thread(new Interaction(blockingQueue));
        try {
            blockingQueue.add(null);
            Assertions.fail("Null");
        }
        catch (NullPointerException ignored) {
        }
    }
}
