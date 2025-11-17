package lesson9;

public class Person {
    int id;
    String name;
    String surname;
    int age;
    String phone;
    
    public Person() {
    }
    

    public Person(int id, String name, String surname, int age, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
    }
    

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Ad: " + name);
        System.out.println("Soyad: " + surname);
        System.out.println("Yaş: " + age);
        System.out.println("Telefon: " + phone);
    }
}