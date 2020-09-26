package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        CountDownLatch countDownLatch = new CountDownLatch(10+1);
        for (int i = 1; i < 11; i++) {
            PassengerThread passengerThread = new PassengerThread("Пассажир № " + i, countDownLatch,
                    semaphore);
        }
        while (countDownLatch.getCount() > 1){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countDownLatch.countDown();
        System.out.println("Автобус полон, можно ехать. В добрый путь!");//долго пыталась сделать чтоб
        // в конце выходил этот соут, но так и смогла сделать

    }
}
