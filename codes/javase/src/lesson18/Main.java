package lesson18;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.setBalans(-100);
        System.out.println(bank.getBalans());

        bank.setBalans(500);
        System.out.println(bank.getBalans());
    }
}