package com.test.hello;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_7_CollectorsGroupingBy {

    public static void main(String[] args) throws IOException {
        try (Stream<Path> stream = Files.walk(Path.of("."))) {
//            Map<Boolean, List<Path>> map = stream.collect(Collectors.groupingBy(Files::isDirectory));
//            System.out.println("adresare: " + map.get(true));
//            System.out.println("soubory:  " + map.get(false));

//            Map<Type, List<Path>> map = stream.collect
//                    (Collectors.groupingBy(path -> Files.isDirectory(path) ? Type.DIRECTORY : Type.FILE));
//            System.out.println("adresare: " + map.get(Type.DIRECTORY));
//            System.out.println("soubory:  " + map.get(Type.FILE));

            Map<Type, List<String>> map = stream.collect
                    (Collectors.groupingBy(path -> Files.isDirectory(path) ? Type.DIRECTORY : Type.FILE,
                            Collectors.mapping(Path::getName, Collectors.toList())));
            System.out.println("adresare: " + map.get(Type.DIRECTORY));
            System.out.println("soubory:  " + map.get(Type.FILE));
        }
    }

    enum Type {
        DIRECTORY, FILE
    }

}
