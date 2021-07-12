package com.syncretis.prodConsExtra;

public class Producer implements Runnable{
    private QueueList queue;

    public Producer(QueueList queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
