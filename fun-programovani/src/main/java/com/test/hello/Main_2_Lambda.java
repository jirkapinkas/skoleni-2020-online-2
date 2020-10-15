package com.test.hello;

// interface s prave jednou abstraktni metodou
// se da alternativne zapsat jako lambda vyraz
// Takovy interface je tzv. funkcionalni interface

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
interface I {
    void test();
    default void test2() {

    }
    static void test3() {

    }
}

public class Main_2_Lambda {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "x", "c", "b", "a"));
        // inner (anonymous) class ... pred Java 8
//        strings.sort(new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s2.compareTo(s1);
//            }
//        });

        // nejsloziteji zapsana lambda
//        strings.sort((String s1, String s2) -> {
//                return s2.compareTo(s1);
//            });

        // lambda bez typu
//        strings.sort((s1, s2) -> {
//            return s2.compareTo(s1);
//        });

        // jednoradkova lambda
        strings.sort((s1, s2) -> s2.compareTo(s1));

        // nebo:
//        strings.sort(Comparator.reverseOrder());


        // method reference
//        strings.forEach(string -> System.out.println(string));
        strings.forEach(System.out::println);
    }

}
