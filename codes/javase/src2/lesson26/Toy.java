package lesson26;

public class Toy {
    String name;
    int price;

    public Toy(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[Oyuncaq: " + name + ", Qiymət: " + price + " AZN]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Toy other = (Toy) obj;
        return this.name.equals(other.name) && this.price == other.price;
    }
}
