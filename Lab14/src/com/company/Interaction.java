package com.company;

public class Interaction implements Runnable {

    private static int count = 0;
    private final IBlockingQueue blockingQueue;
    private final int number = count++;


    Interaction(IBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        blockingQueue.take();
        blockingQueue.take();
    }
}
