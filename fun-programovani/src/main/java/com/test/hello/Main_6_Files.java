package com.test.hello;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_6_Files {

    public static void main(String[] args) throws IOException {
        try (Stream<Path> stream = Files.walk(Path.of("."))) {
            stream.forEach(System.out::println);
        }
        System.out.println("*********************");

        // od Java 7
        List<String> strings = Files.readAllLines(Path.of("pom.xml"), StandardCharsets.UTF_8);
        strings.forEach(System.out::println);

        System.out.println("*********************");

        // od Java 8
        try (Stream<String> stream = Files.lines(Path.of("pom.xml"))) {
            stream.forEach(System.out::println);
        }

        System.out.println("*********************");

        try (Stream<Path> stream = Files.walk(Path.of("."))) {
            List<Path> result = stream
                    .filter(path -> path.toString().endsWith(".java"))
                    .filter(path -> fileContainsText(path, "Kokrspanel"))
                    .collect(Collectors.toList());

            result.stream()
                    .forEach(System.out::println);
        }

        System.out.println("*********************");

        try (Stream<Path> stream = Files.walk(Path.of("."))) {
            long sum = stream
                    .filter(path -> !path.toString().contains("target"))
                    .mapToLong(path -> fileSize(path))
                    .sum();
            System.out.println("velikost projektu: " + sum);
        }

    }

    public static long fileSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean fileContainsText(Path path, String text) {
        // 1. (lepsi zpusob) cteni souboru "LAZY" zpusobem
        try(Stream<String> linesStream = Files.lines(path)) {
            return linesStream
                    .anyMatch(line -> line.contains(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 2. zpusob cteni souboru "EAGER" zpusobem
//                        try {
//                            return Files.readAllLines(path).stream()
//                                    .anyMatch(line -> line.contains(text));
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }

    }

}
