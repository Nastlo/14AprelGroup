package lesson09;

public class Task1 {

    public static void main(String[] args) {

        Book book1 = new Book();
        book1.id = 1;
        book1.name = "Java Basics";
        book1.author = "Author A";
        book1.pageCount = 250;
        book1.description = "Beginner Java guide";

        Book book2 = new Book();
        book2.id = 2;
        book2.name = "OOP Concepts";
        book2.author = "Author B";
        book2.pageCount = 320;
        book2.description = "Advanced OOP book";

        System.out.println("=== Book 1 ===");
        book1.printInfo();

        System.out.println("\n=== Book 2 ===");
        book2.printInfo();
        
        System.out.println("\n=== Book 3 (constructor ilə) ===");
        Book book3 = new Book(3, "Design Patterns", "Author C", 400, "Software design patterns");
        book3.printInfo();
    }
}