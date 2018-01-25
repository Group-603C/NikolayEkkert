package com.company;

public interface IBlockingQueue <T> {

    void add(T value);

    T take();
}
