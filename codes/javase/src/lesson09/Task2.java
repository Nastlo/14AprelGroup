package lesson09;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("========== EV İŞİ-1: PERSON ==========\n");
        
        Person person1 = new Person();
        Person person2 = new Person();
        
        person1.id = 1;
        person1.name = "Aysel";
        person1.surname = "Məmmədova";
        person1.age = 25;
        person1.phone = "+994501234567";
        
        person2.id = 2;
        person2.name = "Elnur";
        person2.surname = "Hüseynov";
        person2.age = 30;
        person2.phone = "+994557654321";
        
        System.out.println("=== Birinci Şəxs ===");
        person1.printInfo();
        
        System.out.println("\n=== İkinci Şəxs ===");
        person2.printInfo();
        
        System.out.println("\n========== EV İŞİ-2: EMPLOYEE ==========\n");
        
        Employee emp1 = new Employee();
        Employee emp2 = new Employee("Leyla", "Əliyeva");
        Employee emp3 = new Employee("Kamran", "Həsənov", "Bakı, Nəsimi");
        Employee emp4 = new Employee("Nigar", "+994502223344", 2500);
        
        emp1.id = 1;
        emp1.name = "Murad";
        emp1.surname = "İsmayılov";
        emp1.phone = "+994501112233";
        emp1.address = "Bakı, Yasamal";
        emp1.salary = 3000;
        
        System.out.println("=== Employee 1 (default constructor) ===");
        emp1.printInfo();
        
        System.out.println("=== Employee 2 (name, surname) ===");
        emp2.printInfo();
        
        System.out.println("=== Employee 3 (name, surname, address) ===");
        emp3.printInfo();
        
        System.out.println("=== Employee 4 (name, phone, salary) ===");
        emp4.printInfo();
        
        System.out.println("\n========== DƏRS PRÄ°KTIKÄ°KASI-1: BOOK ==========\n");
        
        Book book1 = new Book();
        Book book2 = new Book();
        
        book1.id = 1;
        book1.name = "Koroğlu";
        book1.author = "Xalq yaradıcılığı";
        book1.pageCount = 250;
        book1.description = "Azərbaycan xalq dastanı";
        
        book2.id = 2;
        book2.name = "Arxayın olun, burada olacağam";
        book2.author = "Çingiz Abdullayev";
        book2.pageCount = 320;
        book2.description = "Detektiv roman";
        
        System.out.println("=== Birinci Kitab ===");
        book1.printInfo();
        
        System.out.println("\n=== İkinci Kitab ===");
        book2.printInfo();
        
        System.out.println("\n========== DƏRS PRÄ°KTIKÄ°KASI-2: COMPUTER ==========\n");
        
        Computer comp1 = new Computer();
        Computer comp2 = new Computer(101);
        Computer comp3 = new Computer("MacBook Pro", "Apple");
        Computer comp4 = new Computer("ThinkPad X1", "Qara", "Lenovo");
        
        comp1.id = 1;
        comp1.brand = "HP";
        comp1.model = "Pavilion";
        comp1.color = "Gümüşü";
        
        System.out.println("=== Computer 1 (default constructor) ===");
        comp1.printInfo();
        
        System.out.println("\n=== Computer 2 (id) ===");
        comp2.printInfo();
        
        System.out.println("\n=== Computer 3 (model, brand) ===");
        comp3.printInfo();
        
        System.out.println("\n=== Computer 4 (model, color, brand) ===");
        comp4.printInfo();
    }
}