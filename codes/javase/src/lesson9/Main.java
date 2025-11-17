package lesson9;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== EV ISI-1: PERSON ==========\n");
        
        Classes person1 = new Classes();
        Classes person2 = new Classes();
        
        person1.id = 1;
        person1.name = "Aysel";
        person1.surname = "Mammadova";
        person1.age = 25;
        person1.phone = "+994501234567";
        
        person2.id = 2;
        person2.name = "Elnur";
        person2.surname = "Huseynov";
        person2.age = 30;
        person2.phone = "+994557654321";
        
        System.out.println("=== Birinci Shexs ===");
        System.out.println("ID: " + person1.id);
        System.out.println("Ad: " + person1.name);
        System.out.println("Soyad: " + person1.surname);
        System.out.println("Yash: " + person1.age);
        System.out.println("Telefon: " + person1.phone);
        
        System.out.println();
        
        System.out.println("=== Ikinci Shexs ===");
        System.out.println("ID: " + person2.id);
        System.out.println("Ad: " + person2.name);
        System.out.println("Soyad: " + person2.surname);
        System.out.println("Yash: " + person2.age);
        System.out.println("Telefon: " + person2.phone);
        
        System.out.println("\n========== EV ISI-2: EMPLOYEE ==========\n");
        
        Employee emp1 = new Employee();
        Employee emp2 = new Employee("Leyla", "Aliyeva");
        Employee emp3 = new Employee("Kamran", "Hasanov", "Baki, Nasimi");
        Employee emp4 = new Employee("Nigar", "+994502223344", 2500);
        
        emp1.id = 1;
        emp1.name = "Murad";
        emp1.surname = "Ismayilov";
        emp1.phone = "+994501112233";
        emp1.address = "Baki, Yasamal";
        emp1.salary = 3000;
        
        System.out.println("=== Employee 1 (default constructor) ===");
        System.out.println("ID: " + emp1.id);
        System.out.println("Ad: " + emp1.name);
        System.out.println("Soyad: " + emp1.surname);
        System.out.println("Telefon: " + emp1.phone);
        System.out.println("Unvan: " + emp1.address);
        System.out.println("Maas: " + emp1.salary);
        
        System.out.println();
        
        System.out.println("=== Employee 2 (name, surname) ===");
        System.out.println("Ad: " + emp2.name);
        System.out.println("Soyad: " + emp2.surname);
        
        System.out.println();
        
        System.out.println("=== Employee 3 (name, surname, address) ===");
        System.out.println("Ad: " + emp3.name);
        System.out.println("Soyad: " + emp3.surname);
        System.out.println("Unvan: " + emp3.address);
        
        System.out.println();
        
        System.out.println("=== Employee 4 (name, phone, salary) ===");
        System.out.println("Ad: " + emp4.name);
        System.out.println("Telefon: " + emp4.phone);
        System.out.println("Maas: " + emp4.salary);
        
        System.out.println("\n========== DERS PRAKTIKASI-1: BOOK ==========\n");
        
        Book book1 = new Book();
        Book book2 = new Book();
        
        book1.id = 1;
        book1.name = "Koroglu";
        book1.author = "Xalq yaradiciligi";
        book1.pageCount = 250;
        book1.description = "Azərbaycan xalq dastani";
        
        book2.id = 2;
        book2.name = "Arxayın olun, burada olacagam";
        book2.author = "Cingiz Abdullayev";
        book2.pageCount = 320;
        book2.description = "Detektiv roman";
        
        System.out.println("=== Birinci Kitab ===");
        System.out.println("ID: " + book1.id);
        System.out.println("Ad: " + book1.name);
        System.out.println("Muellif: " + book1.author);
        System.out.println("Sehife sayi: " + book1.pageCount);
        System.out.println("Tesvir: " + book1.description);
        
        System.out.println();
        
        System.out.println("=== Ikinci Kitab ===");
        System.out.println("ID: " + book2.id);
        System.out.println("Ad: " + book2.name);
        System.out.println("Muellif: " + book2.author);
        System.out.println("Sehife sayi: " + book2.pageCount);
        System.out.println("Tesvir: " + book2.description);
        
        System.out.println("\n========== DERS PRAKTIKASI-2: COMPUTER ==========\n");
        
        Computer comp1 = new Computer();
        Computer comp2 = new Computer(101);
        Computer comp3 = new Computer("MacBook Pro", "Apple");
        Computer comp4 = new Computer("ThinkPad X1", "Qara", "Lenovo");
        
        comp1.id = 1;
        comp1.brand = "HP";
        comp1.model = "Pavilion";
        comp1.color = "Gumushu";
        
        System.out.println("=== Computer 1 (default constructor) ===");
        System.out.println("ID: " + comp1.id);
        System.out.println("Marka: " + comp1.brand);
        System.out.println("Model: " + comp1.model);
        System.out.println("Reng: " + comp1.color);
        
        System.out.println();
        
        System.out.println("=== Computer 2 (id) ===");
        System.out.println("ID: " + comp2.id);
        
        System.out.println();
        
        System.out.println("=== Computer 3 (model, brand) ===");
        System.out.println("Model: " + comp3.model);
        System.out.println("Marka: " + comp3.brand);
        
        System.out.println();
        
        System.out.println("=== Computer 4 (model, color, brand) ===");
        System.out.println("Model: " + comp4.model);
        System.out.println("Reng: " + comp4.color);
        System.out.println("Marka: " + comp4.brand);
    }
}