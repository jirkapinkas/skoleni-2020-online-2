package com.test.hello;

import java.util.stream.Stream;

public class Main_11_InfiniteStream {

    public static void main(String[] args) {
        Stream.iterate(0, e-> e + 1)
                .takeWhile(integer -> integer < 10000)
                .forEach(System.out::println);
    }

}
