package com.syncretis.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Semaphore semaphore = new Semaphore(1);
        ExecutorService service = Executors.newFixedThreadPool(50);
        FileWriter fileWriter= new FileWriter("File.txt", true);

            for (int i = 0; i < 1000; i++) {
                service.submit(new Number(fileWriter, semaphore));
            }
            Thread.sleep(15000);
            service.shutdownNow();
    }
}

