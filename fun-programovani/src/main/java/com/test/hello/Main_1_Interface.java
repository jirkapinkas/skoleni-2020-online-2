package com.test.hello;

import java.util.*;

interface I1 {
    /*public static final*/ String CONSTANT = "stuff";
    void test();
    // od Java 8:
    default void test2() { // tohle je klasicka instancni metoda!!!

    }
    static void test3() {

    }
    // od Java 9:
//    private void test4() { // private default metoda
//
//    }
//    private static void test5() {
//
//    }
}

// kolize metod pred Java 8: TOTO JE NERESITELNA SITUACE!!!
//interface A {
//    void test();
//}
//
//interface B {
//    int test();
//}
//
//interface C extends A, B {
//}

interface A {
    default void test() {
        System.out.println("do stuff A");
    }
}
interface B {
    default void test() {
        System.out.println("do stuff B");
    }
}

interface C extends A, B {
    @Override
    default void test() {
        A.super.test();
//        System.out.println("do stuff C");
    }
}

public class Main_1_Interface {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "x", "c", "b", "a"));

        // do Java 8
//        Collections.sort(strings);

        // od Java 8
        strings.sort(Comparator.naturalOrder());

        System.out.println(strings);
    }
}
