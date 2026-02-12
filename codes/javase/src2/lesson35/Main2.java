package lesson35;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main2 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(1);
		list.add(2);
		list.add(3);
		
		Set<Integer> unique = new HashSet<>();
		Set<Integer> duplicates = new HashSet<>();
		
		for(Integer num : list) {
			if(!unique.add(num)) {
				duplicates.add(num);
			}
		}

		System.out.println(duplicates);
		
	}

}
