package lesson18;

public class Bank {
    private int balans;

    public void setBalans(int balans) {
        if (balans < 0) {
            this.balans = 0;
            System.out.println("Balans 0-dan kicik ola bilmez");
        } else {
            this.balans = balans;
        }
    }

    public int getBalans() {
        return balans;
    }
}
