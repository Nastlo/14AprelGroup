package lesson32;

class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    <E> void print(E data) {
        System.out.println(data);
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(10);
        System.out.println(box1.get());

        Box<String> box2 = new Box<>();
        box2.set("Salam");
        System.out.println(box2.get());

        box1.print("Generic metod isledi");
        box2.print(25.5);
    }
}
