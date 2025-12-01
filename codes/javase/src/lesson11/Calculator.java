package lesson11;

public class Calculator {

    public void calculateCircleLength(Circle circle) {
        double result = 2 * Math.PI * circle.radius;
        circle.length = result;
    }
}
