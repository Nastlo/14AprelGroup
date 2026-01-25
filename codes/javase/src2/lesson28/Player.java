package lesson28;

public class Player implements Cloneable {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

