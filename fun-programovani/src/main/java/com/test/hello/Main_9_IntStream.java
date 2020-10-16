package com.test.hello;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main_9_IntStream {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9,10);
//        Optional<Integer> max = integers.stream()
//                .max(Comparator.naturalOrder());
//        System.out.println(max);

        OptionalInt max = integers.stream()
                .mapToInt(i -> i)
                .max();
        System.out.println(max);

        System.out.println(round(1024.567568468748464849684, 10));

//        IntStream.range(0, 1_000)
//                .mapToObj(i -> UUID.randomUUID())
//                .forEach(System.out::println);

    }

    public static double round(double d, int precision) {
        String mask = IntStream.range(0, precision)
                .mapToObj(i -> "#")
                .collect(Collectors.joining());
        System.out.println("mask: " + mask);
        DecimalFormat df = new DecimalFormat("#." + mask);
        df.setRoundingMode(RoundingMode.HALF_UP);
        String s = df.format(d);
        return Double.parseDouble(s.replace(",", "."));
    }

}
