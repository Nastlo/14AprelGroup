package lesson40;

import java.util.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " - " + age;
    }
}

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("Ali", 25));
        list.add(new Person("Veli", 20));
        list.add(new Person("Aysel", 30));
        list.add(new Person("Nigar", 22));

        Comparator<Person> ageComparator = new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        };

        Collections.sort(list, ageComparator);

        for (Person p : list) {
            System.out.println(p);
        }
    }
}