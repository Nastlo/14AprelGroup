package lesson22;

public class Main {
    public static void main(String[] args) {

        Product product = new Product("Basic Product", 100);
        product.calculateDiscount();

        Electronic electronic = new Electronic("Laptop", 2000);
        electronic.calculateDiscount();

        Clothing clothing = new Clothing("T-shirt", 200);
        clothing.calculateDiscount();
    }
}

