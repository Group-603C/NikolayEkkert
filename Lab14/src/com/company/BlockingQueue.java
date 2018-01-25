package com.company;

public class BlockingQueue <T> implements IBlockingQueue<T> {

    private Box top;

    BlockingQueue() {

        top = null;
    }


    @Override
    public synchronized void add(T value) {

        if (value == null) {
            throw new NullPointerException("No element!");
        }
        top = new Box(top, value);
        notify();
    }

    @Override
    public synchronized T take() {

        while (top == null) {
            interrupt();
        }
        T element = top.element;
        top = top.next;
        return element;
    }

    private void interrupt() {

        try {
            wait();
        }
        catch (InterruptedException ignored) {
        }
    }

    private class Box {

        T element;
        Box next;

        private Box(Box next, T value) {

            this.next = next;
            element = value;
        }
    }
}
