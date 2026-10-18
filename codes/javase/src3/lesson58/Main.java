package lesson58;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println(evenNumbers);

        List<String> names = Arrays.asList("omer", "eli", "veli");

        List<String> upperNames = names.stream()
                .map(name -> name.toUpperCase())
                .toList();

        System.out.println(upperNames);
    }
}