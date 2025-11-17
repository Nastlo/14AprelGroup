package lesson9;

class Person {
    int id;
    String name;
    String surname;
    int age;
    String phone;
}

class Employee {
    int id;
    String name;
    String surname;
    String phone;
    String address;
    int salary;
    
    public Employee() {
    }
    
    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    
    public Employee(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
    
    public Employee(String name, String phone, int salary) {
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }
}

class Book {
    int id;
    String name;
    String author;
    int pageCount;
    String description;
}

class Computer {
    int id;
    String brand;
    String model;
    String color;
    
    public Computer() {
    }
    
    public Computer(int id) {
        this.id = id;
    }
    
    public Computer(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }
    
    public Computer(String model, String color, String brand) {
        this.model = model;
        this.color = color;
        this.brand = brand;
    }
}