package lesson56;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("java", "hello", "world");

        words.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}