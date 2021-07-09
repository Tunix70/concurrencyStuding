package com.syncretis.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Number implements Runnable {
    FileWriter writer;
    Semaphore semaphore;

    public Number(FileWriter writer, Semaphore semaphore){
        this.writer = writer;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            try {
                semaphore.acquire();
                writer.append("Один плюс два");
                writer.append("\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
