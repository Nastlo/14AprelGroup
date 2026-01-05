package lesson21;

public class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public final void showAll() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
