package lesson10;

public class Main {
    public static void main(String[] args) {
        Methods m = new Methods();

        // Task 1
        int number = 5;
        System.out.println("Kvadrat: " + m.square(number));

        // Task 2
        int a = 10;
        int b = 20;
        System.out.println("Ən böyük: " + Methods.max(a, b));

        // Task 3
        int num = 7;
        System.out.println("Təkdir? " + m.isOdd(num));
    }
}