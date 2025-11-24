package lesson09;

public class Employee {
    int id;
    String name;
    String surname;
    String phone;
    String address;
    int salary;


    public Employee() {
        System.out.println("Default constructor işə düşdü");
    }


    public Employee(String name) {
        System.out.println("2-ci constructor işə düşdü: name = " + name);
        this.name = name;
    }


    public Employee(String name, String surname) {
        System.out.println("3-cü constructor işə düşdü: name = " + name + ", surname = " + surname);
        this.name = name;
        this.surname = surname;
    }

    public Employee(String name, String surname, String address) {
        System.out.println("4-cü constructor işə düşdü: name = " + name + ", surname = " + surname + ", address = " + address);
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Employee(String name, String phone, int salary) {
        System.out.println("5-ci constructor işə düşdü: name = " + name + ", phone = " + phone + ", salary = " + salary);
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }


    public void printInfo() {
        System.out.println("-----------------------");
        System.out.println("ID: " + id);
        System.out.println("Ad: " + name);
        System.out.println("Soyad: " + surname);
        System.out.println("Telefon: " + phone);
        System.out.println("Ünvan: " + address);
        System.out.println("Maaş: " + salary);
        System.out.println("-----------------------");
    }
}