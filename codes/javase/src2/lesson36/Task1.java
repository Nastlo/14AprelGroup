package lesson36;

import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 2, 4, 1, 5};

        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            numbers.add(array[i]);
        }

        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        System.out.println(numbers);
        System.out.println(sum);
    }
}
