package lesson29;

public class School {

    static class Student {
        String name;
        int grade;

        void showInfo() {
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Ali";
        s1.grade = 10;
        s1.showInfo();
    }
}

