package lesson31;

public class MainClass {

    public static void main(String[] args) {

        CheckRange checkRange = new CheckRange();

        try {
            checkRange.checkValueRange(25);
        } catch (OutOfRangeValueException e) {
            System.out.println(e);
        }
    }
}

