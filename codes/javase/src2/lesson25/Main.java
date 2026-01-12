package lesson25;

public class Main {
    public static void main(String[] args) {

        Transport t1 = new Car();
        Transport t2 = new Bus();
        Transport t3 = new Bicycle();

        t1.move();
        t2.move();
        t3.move();
    }
}
