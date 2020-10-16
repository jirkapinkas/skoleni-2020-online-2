package com.test.hello;

import com.test.hello.pojo.Dog;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_5_Collectors {

    public static void main(String[] args) throws IOException {
        List<Dog> dogs = new ArrayList<>(List.of(
                new Dog("Jarda", "Kokrspanel", 11),
                new Dog("Honza", "Pitbul", 8),
                new Dog("Martin", "Civava", 12),
                new Dog("Prymula", "Jezevcik", 15),
                new Dog("Jirka", "Stafford", 2),
                new Dog("Likvidator", "Vlcak", 16),
                new Dog("Hafik", "Smeska", 22)
        ));

        List<String> dogNames = dogs.stream()
                .map(Dog::getName)
                .collect(Collectors.toList());

        String dogNamesString = dogs.stream()
                .map(Dog::getName)
                .collect(Collectors.joining(", "));
        System.out.println(dogNamesString);

        try (Stream<Path> stream = Files.walk(Path.of("."))) {
            stream.forEach(System.out::println);
        }

        // od Java 7
        List<String> strings = Files.readAllLines(Path.of("pom.xml"), StandardCharsets.UTF_8);

        // od Java 8
        try (Stream<String> stream = Files.lines(Path.of("pom.xml"))) {
            stream.forEach(System.out::println);
        }

    }

}
