package com.syncretis.prodConsExtra;

public class Consumer implements Runnable{
    QueueList queue;

    public Consumer(QueueList queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                queue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
