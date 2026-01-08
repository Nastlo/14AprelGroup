package lesson24;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}
