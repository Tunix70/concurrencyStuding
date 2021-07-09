package com.syncretis.producerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    Queue queue;
    Semaphore semaphore;

    public Consumer(Queue queue, Semaphore semaphore) {
        this.queue = queue;
        this.semaphore = semaphore;
    }

    public void poll() throws InterruptedException {
            if (!queue.isEmpty()) {
                semaphore.acquire();
                queue.poll();
                semaphore.release();
            } else {
                System.out.println("can't poll");
            }
    }

    @Override
    public void run() {
        try {
            poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
