package lesson09;

public class Task3 {

    public static void main(String[] args) {


        Person p1 = new Person();
        p1.id = 1;
        p1.name = "Aslan";
        p1.surname = "Əliyev";
        p1.age = 22;
        p1.phone = "055-123-45-67";


        Person p2 = new Person();
        p2.id = 2;
        p2.name = "Murad";
        p2.surname = "Hüseynov";
        p2.age = 25;
        p2.phone = "070-987-65-43";


        System.out.println("=== Person 1 ===");
        p1.printInfo();

        System.out.println("\n=== Person 2 ===");
        p2.printInfo();
        

        System.out.println("\n=== Person 3 (constructor ilə) ===");
        Person p3 = new Person(3, "Leyla", "Məmmədova", 28, "051-555-66-77");
        p3.printInfo();
    }
}