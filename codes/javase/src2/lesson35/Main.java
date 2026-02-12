package lesson35;

import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		HashSet<String> colors = new HashSet<>();
		
		colors.add("blue");
		colors.add("red");
		colors.add("yellow");
		colors.add("pink");
		
		for (String reng : colors) {
			System.out.println(reng);
		}

	}

}
