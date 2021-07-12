package com.syncretis.producerConsumer;

import java.util.Queue;

public class Consumer implements Runnable{
    Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        while(true) {
            if (!queue.isEmpty()) {
                queue.poll();
            } else {
                System.out.println("can't poll");
            }
            System.out.println("Queue size = " + queue.size());
        }
    }
}
