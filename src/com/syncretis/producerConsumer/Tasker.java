package com.syncretis.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Tasker {
    public static final int MAX_SIZE_LENGTH = 10;
    private  static Queue<Integer> queue = new LinkedList<>();
    public static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {

        Producer producer = new Producer(queue, semaphore);
        Consumer consumer = new Consumer(queue, semaphore);

        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);

        while(true) {
            consumerThread.start();
            producerThread.start();
            System.out.println(queue.size());
        }

    }
}
