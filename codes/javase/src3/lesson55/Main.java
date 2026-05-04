package lesson55;

import java.util.*;
import java.util.function.*;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Ali", 45);
        Student s2 = new Student("Veli", 60);
        Student s3 = new Student("Aysel", 75);
        Student s4 = new Student("Murad", 30);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        Function<Student, String> getNameFunction = new Function<Student, String>() {
            public String apply(Student s) {
                return s.getName();
            }
        };

        Predicate<Student> passedFilter = new Predicate<Student>() {
            public boolean test(Student s) {
                return s.getScore() >= 50;
            }
        };

        Consumer<String> printConsumer = new Consumer<String>() {
            public void accept(String name) {
                System.out.println(name);
            }
        };

        students.stream()
                .filter(passedFilter)
                .map(getNameFunction)
                .forEach(printConsumer);
    }
}
