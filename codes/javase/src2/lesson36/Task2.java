package lesson36;

import java.util.HashSet;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {

        String text = "hello world";

        Set<Character> letters = new HashSet<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
        }

        System.out.println(letters.size());
    }
}

