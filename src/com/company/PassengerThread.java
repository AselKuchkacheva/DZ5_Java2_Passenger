package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {

    private CountDownLatch countDownLatch;
    private Semaphore semaphore;

    public PassengerThread(String name, CountDownLatch countDownLatch, Semaphore semaphore ) {
        super(name);
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        start();

    }

    public void run(){

        try {
            semaphore.acquire();
            countDownLatch.countDown();
            System.out.println( getName() + " покупаеть билет в кассе." );
            sleep(2000);
            System.out.println(getName() + " купил билет и сел в автобус.");
            semaphore.release();
           // sleep(2000);  //здесь если добавить слиип, то покупают и садяться в автобус одновременно,
            // как првильно незнаю?
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
