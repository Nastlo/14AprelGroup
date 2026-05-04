package lesson54;

interface Square {
    int calculate(int number);
}

public class Main {
    public static void main(String[] args) {

        Square square = (number) -> number * number;

        int reqem = 7;
        int kvadratı = square.calculate(reqem);

        System.out.println("kvadratı: " + kvadratı);
    }
}
