package lesson37;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> usaqlar = new HashMap<>();

        usaqlar.put("Ali", 10);
        usaqlar.put("Aysu", 13);
        usaqlar.put("Murad", 15);
        usaqlar.put("Leyla", 12);

        System.out.println("Butun usaqlar:");
        for (String ad : usaqlar.keySet()) {
            System.out.println(ad + " " + usaqlar.get(ad));
        }

        System.out.println("Yasi 12-den boyuk olanlar:");
        for (String ad : usaqlar.keySet()) {
            if (usaqlar.get(ad) > 12) {
                System.out.println(ad + " " + usaqlar.get(ad));
            }
        }
    }
}

