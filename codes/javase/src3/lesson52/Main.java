package lesson52;

import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Ali", 45),
                new Student("Veli", 60),
                new Student("Aysel", 75),
                new Student("Murad", 30),
                new Student("Lale", 90)
        );

        List<String> upperNamesFiltered = students.stream()
                .filter(s -> s.score > 50)
                .map(s -> s.name.toUpperCase())
                .collect(Collectors.toList());

        int maxScore = students.stream()
                .map(s -> s.score)
                .reduce(0, (a, b) -> a > b ? a : b);

        System.out.println("Filtered count: " + upperNamesFiltered.size());

        upperNamesFiltered.forEach(System.out::println);

        System.out.println("Max score: " + maxScore);
    }
}