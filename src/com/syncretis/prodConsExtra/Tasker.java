package com.syncretis.prodConsExtra;

import java.util.LinkedList;
import java.util.Queue;

public class Tasker {
    public static final int MAX_SIZE_LENGTH = 10;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        QueueList queueList = new QueueList(queue);

        Producer producer = new Producer(queueList);
        Consumer consumer = new Consumer(queueList);

        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);

            consumerThread.start();
            producerThread.start();
    }
}
