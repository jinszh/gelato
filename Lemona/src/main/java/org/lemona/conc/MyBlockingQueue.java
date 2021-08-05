package org.lemona.conc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyBlockingQueue<T> {
    BlockingQueue<T> inner;
    int capacity =  100;

    MyBlockingQueue(){
        inner = new ArrayBlockingQueue<>(capacity);
    }

    public void get(T e) throws InterruptedException{
        inner.put(e);
        inner.add(e);
        inner.offer(e);
        inner.take();
    }
}
