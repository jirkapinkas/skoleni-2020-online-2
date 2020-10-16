package com.test.hello;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main_10_Reduce {

    public static void main(String[] args) {
        System.out.println(0.1 + 0.2); // 0.30000000000000004
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println(a.add(b)); // 0.3

        double sum = DoubleStream.of(0.1, 0.2)
                .sum();
        System.out.println(sum); // 0.30000000000000004

        List<BigDecimal> bigDecimals = List.of(new BigDecimal("0.1"), new BigDecimal("0.2"));
        Optional<BigDecimal> sumBigDecimal = bigDecimals.stream()
//                .reduce((suma, e) -> suma.add(e));
                .reduce(BigDecimal::add);
        System.out.println(sumBigDecimal);
    }

}
