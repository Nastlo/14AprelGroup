package lesson31;

public class CheckRange {

    public void checkValueRange(int value) throws OutOfRangeValueException {

        int min = 10;
        int max = 20;

        if (value < min || value > max) {
            throw new OutOfRangeValueException("Dəyər aralıqdan kənardadır");
        } else {
            System.out.println("Dəyər müəyyən aralıqdadır");
        }
    }
}

