package lesson20;

public class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showAll() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

