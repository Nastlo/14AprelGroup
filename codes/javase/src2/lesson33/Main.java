package lesson33;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<String> students = new ArrayList<>();
		
		ArrayList<Integer> grades = new ArrayList<>();
		
		students.add("Aslan");
		students.add("Omer");
		students.add("Sexavet");
		students.add("Eli Imran");
		students.add("Vuqar");
		
		grades.add(85);
		grades.add(90);
		grades.add(78);
		grades.add(88);
		grades.add(85);
		grades.add(95);
		
		for(int i = 0; i < students.size(); i++) {
			System.out.println(
					students.get(i) + " - grades" + grades.get(i)
					);
		}

	}

}
