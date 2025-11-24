package lesson09;

public class Book {
    int id;
    String name;
    String author;
    int pageCount;
    String description;
    

    public Book() {
    }

    public Book(int id, String name, String author, int pageCount, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
        this.description = description;
    }
    

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Ad: " + name);
        System.out.println("Müəllif: " + author);
        System.out.println("Səhifə sayı: " + pageCount);
        System.out.println("Təsvir: " + description);
    }
}