package lesson9;

public class Task4 {

    public static void main(String[] args) {

        Employee emp1 = new Employee();
        Employee emp2 = new Employee("Aslan");
        Employee emp3 = new Employee("Leyla", "Qasımova");
        Employee emp4 = new Employee("Murad", "0501234567", 1200);

        emp1.printInfo();
        emp2.printInfo();
        emp3.printInfo();
        emp4.printInfo();
    }
}