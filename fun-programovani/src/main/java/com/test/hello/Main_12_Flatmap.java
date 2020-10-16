package com.test.hello;

import java.util.List;

public class Main_12_Flatmap {

    public static void main(String[] args) {
        List.of(
                List.of(1,2,3),
                List.of(1,3,6)
        ).stream()
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

}
