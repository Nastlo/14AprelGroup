package lesson27;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Car car1 = new Car("BMW", "M5");

        System.out.println(car1.hashCode());

        Car car2 = (Car) car1.clone();

        System.out.println(car2.hashCode());
    }
}

