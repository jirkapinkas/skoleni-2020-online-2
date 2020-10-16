package com.test.hello;

import com.test.hello.pojo.Dog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_8_Comparator {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(List.of(
                new Dog("Jarda", "Vlcak", 11),
                new Dog("Honza", "Civava", 8),
                new Dog("Martin", "Civava", 12),
                new Dog("Prymula", "Vlcak", 15),
                new Dog("Jirka", "Civava", 2),
                new Dog("Likvidator", "Vlcak", 16),
                new Dog("Hafik", "Civava", 22)
        ));
        dogs.stream()
                .sorted(Comparator.comparing(Dog::getRace).thenComparing(Dog::getName))
                .forEach(System.out::println);
    }

}
