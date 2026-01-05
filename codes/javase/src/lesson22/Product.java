package lesson22;

public class Product {

    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double calculateDiscount() {
        double discountedPrice = price - (price * 0.10);
        System.out.println("Product endirimli qiymət: " + discountedPrice);
        return discountedPrice;
    }
}
