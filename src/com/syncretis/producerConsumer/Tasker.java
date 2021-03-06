package com.syncretis.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Tasker {
    public static final int MAX_SIZE_LENGTH = 10;
    private  static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);

            consumerThread.start();
            producerThread.start();
    }
}
