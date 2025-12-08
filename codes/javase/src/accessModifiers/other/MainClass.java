package accessModifiers.other;

import accessModifiers.Book;

public class MainClass {
    public static void main(String[] args) {
    																			
        Book b = new Book();

        b.title = "Clean Code";

        System.out.println("Title: " + b.title);
    }
}
