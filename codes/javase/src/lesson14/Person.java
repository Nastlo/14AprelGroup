package lesson14;

public class Person {

    public String name;
    private int age;
    protected String city;
    String student;

    public static int staticCount = 0;

    public Person(String name, int age, String city, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.student = isStudent ? "Yes" : "No";
        staticCount++;
    }

    private Person(int age) {
        this.age = age;
    }

    protected Person(String name) {
        this.name = name;
    }

    Person() {
    }

    public void publicMethod() {
        System.out.println("Public metod");
    }

    private void privateMethod() {
        System.out.println("Private metod");
    }

    protected void protectedMethod() {
        System.out.println("Protected metod");
    }

    void defaultMethod() {
        System.out.println("Default metod");
    }

    public void callPrivateMethod() {
        privateMethod();
    }

    public void callProtectedMethod() {
        protectedMethod();
    }

    public void callDefaultMethod() {
        defaultMethod();
    }

    public void showFinalValue(final int value) {
        System.out.println(value);
    }
}
