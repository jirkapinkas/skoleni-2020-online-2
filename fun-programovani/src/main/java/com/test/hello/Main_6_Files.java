package com.test.hello;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_6_Files {

    public static void main(String[] args) throws IOException {
        try (Stream<Path> stream = Files.walk(Path.of("."))) {
            List<Path> result = stream
                    .filter(path -> path.toString().endsWith(".java"))
                    .filter(path -> fileContainsText(path, "Kokrspanel"))
                    .collect(Collectors.toList());

            result.stream()
                    .forEach(System.out::println);
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
