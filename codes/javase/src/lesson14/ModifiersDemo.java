package lesson14;

public class ModifiersDemo {
    public static void main(String[] args) {

        Person p1 = new Person("Omer", 18, "Baki", true);

        p1.publicMethod();
        p1.callProtectedMethod();
        p1.callDefaultMethod();
        p1.callPrivateMethod();

        p1.showFinalValue(50);

        System.out.println(Person.staticCount);
    }
}
