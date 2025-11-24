package lesson10;

public class Methods {

    public int square(int number) {
        return number * number;
    }


    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }
}