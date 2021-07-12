package com.syncretis.producerConsumer;

import java.util.Queue;

public class Producer implements Runnable{
    Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            if (queue.size() < Tasker.MAX_SIZE_LENGTH) {
                queue.add(7);
            } else {
                System.out.println("can't add");
            }
            System.out.println("Queue size = " + queue.size());
        }
    }
}
