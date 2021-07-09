package com.syncretis.producerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    Queue queue;
    Semaphore semaphore;

    public Producer(Queue queue, Semaphore semaphore) {
        this.queue = queue;
        this.semaphore = semaphore;
    }

    public void add() throws InterruptedException {
            if (queue.size() <= Tasker.MAX_SIZE_LENGTH) {
                semaphore.acquire();
                queue.add(7);
                semaphore.release();
            } else {
                System.out.println("can't add");
            }
    }

    @Override
    public void run() {
        try {
            add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
