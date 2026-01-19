package lesson26;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy("Maşın", 10);
        System.out.println(toy1);

        Toy toy2 = new Toy("Top", 5);
        Toy toy3 = new Toy("Top", 5);

        System.out.println(toy2.equals(toy3));
    }
}
