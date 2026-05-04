package lesson53;

import java.util.Arrays;
import java.util.List;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {

        
        List<Product> products = Arrays.asList(
                new Product("Telefon", 120),
                new Product("Mouse", 30),
                new Product("Monitor", 200),
                new Product("Keyboard", 50),
                new Product("Noutbuk", 900)
        );

        String result = products.stream()
                .filter(p -> p.price > 60) 
                .map(p -> p.name) 
                .sorted() 
                .reduce("", (a, b) -> a + (a.isEmpty() ? "" : " ") + b); 

        System.out.println(result);
    }
}
