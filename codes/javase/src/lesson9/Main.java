package lesson9;

public class Main {
    public static void main(String[] args) {

        // ===============================
        //     DƏRS PRAKTİKASI 1
        // ===============================
        int book1Id = 1;
        String book1Name = "Java Kitabı";
        String book1Author = "Ali";
        int book1PageCount = 200;
        String book1Description = "Yeni başlayanlar üçün";

        int book2Id = 2;
        String book2Name = "OOP Kitabı";
        String book2Author = "Veli";
        int book2PageCount = 300;
        String book2Description = "Obyekt yönümlü proqramlama";

        System.out.println("Book 1: " + book1Id + " " + book1Name + " " + book1Author);
        System.out.println("Book 2: " + book2Id + " " + book2Name + " " + book2Author);


        // ===============================
        //     DƏRS PRAKTİKASI 2
        // ===============================
        int comp1Id = 1;
        String comp1Brand = "Unknown";
        String comp1Model = "Unknown";
        String comp1Color = "Black";

        int comp2Id = 2;
        String comp2Brand = "HP";
        String comp2Model = "Unknown";
        String comp2Color = "Black";

        int comp3Id = 3;
        String comp3Brand = "ASUS";
        String comp3Model = "ROG";
        String comp3Color = "Red";

        System.out.println("Computer 1: " + comp1Id + " " + comp1Brand);
        System.out.println("Computer 2: " + comp2Id + " " + comp2Brand);
        System.out.println("Computer 3: " + comp3Id + " " + comp3Brand + " " + comp3Model);


        // ===============================
        //         EV İŞİ 1
        // ===============================
        int person1Id = 1;
        String person1Name = "Ramin";
        String person1Surname = "Aliyev";
        int person1Age = 20;
        String person1Phone = "0501112233";

        int person2Id = 2;
        String person2Name = "Nigar";
        String person2Surname = "Quliyeva";
        int person2Age = 22;
        String person2Phone = "050889977";

        System.out.println("Person 1: " + person1Name + " " + person1Surname);
        System.out.println("Person 2: " + person2Name + " " + person2Surname);


        // ===============================
        //         EV İŞİ 2
        // ===============================

        // Employee 1 (default)
        int emp1Id = 0;
        String emp1Name = "Unknown";
        String emp1Surname = "Unknown";
        String emp1Phone = "0000000";
        String emp1Address = "No Address";
        int emp1Salary = 0;

        // Employee 2 (name)
        String emp2Name = "Aylin";
        String emp2Surname = "Unknown";
        String emp2Phone = "0000000";
        String emp2Address = "No Address";
        int emp2Salary = 0;

        // Employee 3 (name, surname, phone)
        String emp3Name = "Emin";
        String emp3Surname = "Kerimov";
        String emp3Phone = "0512223344";
        String emp3Address = "No Address";
        int emp3Salary = 0;

        // Employee 4 (name, phone, salary)
        String emp4Name = "Nurlan";
        String emp4Surname = "Unknown";
        String emp4Phone = "0513332211";
        String emp4Address = "No Address";
        int emp4Salary = 1200;

        System.out.println("Employee 1: " + emp1Name);
        System.out.println("Employee 2: " + emp2Name);
        System.out.println("Employee 3: " + emp3Name + " " + emp3Surname);
        System.out.println("Employee 4: " + emp4Name + " salary=" + emp4Salary);
    }
}
