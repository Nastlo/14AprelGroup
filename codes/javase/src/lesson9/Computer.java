package lesson9;

public class Computer {
    int id;
    String brand;
    String model;
    String color;


    public Computer() {
    }


    public Computer(int id) {
        this.id = id;
    }


    public Computer(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }


    public Computer(String model, String color, String brand) {
        this.model = model;
        this.color = color;
        this.brand = brand;
    }


    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Marka: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rəng: " + color);
    }
}