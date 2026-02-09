package lesson34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();

        words.add("Java");
        words.add("Python");
        words.add("C#");
        words.add("JavaScript");

        System.out.println("Original list:");
        System.out.println(words);

        Collections.reverse(words);

        System.out.println("Reversed list:");
        System.out.println(words);
    }
}
