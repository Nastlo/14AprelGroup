package lesson13;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        System.out.println("10 ədəd daxil edin:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] newArr = Arrays.copyOf(arr, 5);
        System.out.println(Arrays.toString(newArr));

        Arrays.fill(newArr, 7);
        System.out.println(Arrays.toString(newArr));

        boolean equal = Arrays.equals(arr, newArr);
        System.out.println(equal);

        System.out.print("Axtarmaq istədiyiniz elementi daxil edin: ");
        int search = sc.nextInt();

        int index = Arrays.binarySearch(arr, search);

        if (index >= 0) {
            System.out.println("Bu element massivdə var");
        } else {
            System.out.println("Bu element massivdə yoxdur");
        }
    }
}
 