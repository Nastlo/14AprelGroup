package lesson28;

public class Main {
    public static void main(String[] args) throws Exception {

        Player p1 = new Player("Alex", 100);
        Player p2 = (Player) p1.clone();

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
    }
}

