package com.test.hello;

import com.test.hello.pojo.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main_3_Stream {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(List.of(
                new Dog("Jarda", "Kokrspanel", 11),
                new Dog("Honza", "Pitbul", 8),
                new Dog("Martin", "Civava", 12),
                new Dog("Prymula", "Jezevcik", 15),
                new Dog("Jirka", "Stafford", 2),
                new Dog("Likvidator", "Vlcak", 16),
                new Dog("Hafik", "Smeska", 22)
                ));

        Stream<String> stream = dogs.stream()
//                .peek(dog -> System.out.println("before filter"))
//                .filter(dog -> ageGreaterThan(dog.getAge(), 10))
//                .filter(dogPredicateAgeLessThan20)
                .peek(dog -> System.out.println("before Dog::getName"))
                .map(Dog::getName)
//                .sorted()
                .peek(dog -> System.out.println("before String::toUpperCase"))
                .map(String::toUpperCase);
        stream.forEach(System.out::println);

        // vyse uvedeny stream je neco jako:
//        for (Dog dog : dogs) {
//            if(!...) {
//                continue;
//            }
//            if(!...) {
//                continue;
//            }
//            String name = dog.getName();
//            String nameUpperCase = name.toUpperCase();
//            System.out.println(nameUpperCase);
//        }

    }

    public static Predicate<Dog> dogPredicateAgeLessThan20 = dog -> dog.getAge() <= 20;

    public static boolean ageGreaterThan(int age, int number) {
        return age > number;
    }

    public static boolean ageLessThan(int age, int number) {
        return age < number;
    }

}
