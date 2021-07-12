package com.syncretis.prodConsExtra;

import java.util.Queue;

public class QueueList {
    private Queue<Integer> queue;

    public QueueList(Queue<Integer> queue) {
        this.queue = queue;
    }

    synchronized void add() throws InterruptedException {
        if(queue.size() < Tasker.MAX_SIZE_LENGTH) {
            queue.add(7);
        }else {
            System.out.println("can't add");
            notify();
            wait();
        }
        System.out.println("Queue size = " + queue.size());
    }

    synchronized void poll() throws InterruptedException {
        if(!queue.isEmpty()) {
            queue.poll();
        }else {
            System.out.println("can't poll");
            notify();
            wait();
        }
        System.out.println("Queue size = " + queue.size());
    }
}
