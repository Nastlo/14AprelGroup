package lesson21;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal("Generic Animal", 5);
        animal.showAll();

        System.out.println("----");

        Cat cat = new Cat("Mestan", 2, "Black");
        cat.showAll();
    }
}
