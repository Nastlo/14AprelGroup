package lessson11;

public class MainClass {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.radius = 5;   

        Calculator calc = new Calculator();
        calc.calculateCircleLength(circle);  

        System.out.println("Length: " + circle.length);
    }
}
