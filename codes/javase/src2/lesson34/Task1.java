package lesson34;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        int eded = 10;

        while (numbers.size() < 40) {
            if (eded % 2 == 0) {
                numbers.add(eded);
            }
            eded++;
        }

        System.out.println(numbers);
    }
}
