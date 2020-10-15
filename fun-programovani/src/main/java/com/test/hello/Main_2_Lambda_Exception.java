package com.test.hello;

import java.util.Arrays;
import java.util.List;

public class Main_2_Lambda_Exception {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            sleep(100);
        };

        List<Integer> integers = List.of(1,2,3,4,5);
        integers.stream()
                // TOHLE FUNGOVAT BUDE:!!!
//                .map(i -> Integer.toString(i))
//                .map(i -> i.toString())
//                .map(Object::toString)
                .map(String::valueOf)
                // TOHLE FUNGOVAT NEBUDE:!!!
//                .map(Integer::toString)
                .forEach(System.out::println);

        // RESENI:
        // A. klasicky foreach cyklus
        // B. index zmenit na atribut (ale tohle muze zmenit chovani)
        // C. AtomicInteger
        // D. Custom trida Counter
        int index = 0;
//        integers.forEach(i -> {
//            // processing zaznamu
//            if(index % 1_000 == 0) {
//                System.out.println("zprocesovano zaznamu: " + (index * 100 / integers.size()));
//            }
//            index++;
//        });

        Counter counter = new Counter();
        integers.forEach(i -> {
            // processing zaznamu
            if(counter.getValue() % 1_000 == 0) {
                System.out.println("zprocesovano zaznamu: " + (counter.getValue() * 100 / integers.size()));
            }
            counter.increment();
        });

        // tady neni zadny problem, tohle bude na 100% fungovat:
//        for(Integer i : integers) {
//              // processing zaznamu
//            if(index % 1_000 == 0) {
//                System.out.println("zprocesovano zaznamu: " + (index * 100 / integers.size()));
//            }
//            index++;
//        }

    }

    public static class Counter {
        private int i;

        public void increment() {
            i++;
        }

        public int getValue() {
            return i;
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
