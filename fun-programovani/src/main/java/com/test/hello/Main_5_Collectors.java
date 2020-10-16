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
import java.util.function.Predicate;
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

        System.out.println("************************");

        Predicate<Path> predicateIsRegularFile = path -> Files.isRegularFile(path);
        Predicate<Path> predicateIsntIdeaFile = path -> !path.toString().contains("\\.idea\\");
        Predicate<Path> predicateIsntTargetFile = path -> !path.toString().contains("\\target\\");
        Predicate<Path> predicateProjectFiles = predicateIsRegularFile.and(predicateIsntIdeaFile).and(predicateIsntTargetFile);

        try (Stream<Path> stream = Files.walk(Path.of("."))) {
            // varianta 1
//            stream
//                    .filter(path -> Files.isRegularFile(path))
//                    .filter(path -> !path.toString().contains("\\.idea\\"))
//                    .filter(path -> !path.toString().contains("\\target\\"))
//                    .forEach(System.out::println);
            // varianta 2
//            stream
//                    .filter(predicateIsRegularFile)
//                    .filter(predicateIsntIdeaFile)
//                    .filter(predicateIsntTargetFile)
//                    .forEach(System.out::println);
            // varianta 3
//            stream
//                    .filter(predicateIsRegularFile.and(predicateIsntIdeaFile).and(predicateIsntTargetFile))
//                    .forEach(System.out::println);
            // varianta 4
            stream
                    .filter(predicateProjectFiles)
                    .forEach(System.out::println);
        }

    }

}
