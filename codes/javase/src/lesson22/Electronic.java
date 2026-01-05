package lesson22;

public class Electronic extends Product {

    public Electronic(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        double discountedPrice = price - (price * 0.20);
        System.out.println("Electronic endirimli qiymət: " + discountedPrice);
        return discountedPrice;
    }
}
