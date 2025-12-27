package lesson19;

public class InventoryItem {
    private String name;
    private int quantity;
    private double price;
    
    public InventoryItem() {
    }
    
    public InventoryItem(String name, int quantity, double price) {
        this.name = name;
        setQuantity(quantity);
        setPrice(price);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }
    
    public void displayInfo() {
        System.out.println("Məhsul: " + name);
        System.out.println("Miqdar: " + quantity);
        System.out.println("Qiymət: " + price + " AZN");
        System.out.println("------------------------");
    }
    
    public static void main(String[] args) {
        InventoryItem item1 = new InventoryItem("Laptop", 10, 1500.50);
        item1.displayInfo();
        
        InventoryItem item2 = new InventoryItem();
        item2.setName("Telefon");
        item2.setQuantity(-5);
        item2.setPrice(800.0);
        item2.displayInfo();
        
        InventoryItem item3 = new InventoryItem("Klaviatura", 20, 50.0);
        item3.setPrice(-10.0);
        item3.displayInfo();
    }
}