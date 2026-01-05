package lesson20;

public class Cat extends Animal {
    String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public void showAll() {
        super.showAll();
        System.out.println("Color: " + color);
    }
}
