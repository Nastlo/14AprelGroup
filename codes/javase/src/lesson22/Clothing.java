package lesson22;

public class Clothing extends Product {

    public Clothing(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        double discountedPrice = price - (price * 0.15);
        System.out.println("Clothing endirimli qiymət: " + discountedPrice);
        return discountedPrice;
    }
}
