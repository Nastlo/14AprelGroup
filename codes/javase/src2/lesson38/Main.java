package lesson38;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // TAPŞIRIQ 1

        Map<String, String> map1 = new HashMap<>();

        map1.put("Ad", "Aysel");
        map1.put("Şəhər", "Bakı");
        map1.put("Dövlət", "Azərbaycan");

        String enUzunAcar = "";

        for (String acar : map1.keySet()) {
            if (acar.length() > enUzunAcar.length()) {
                enUzunAcar = acar;
            }
        }

        System.out.println("Ən uzun açar: " + enUzunAcar);


        // TAPŞIRIQ 2

        Map<String, Integer> map2 = new HashMap<>();

        map2.put("Riyaziyyat", 80);
        map2.put("Fizika", 70);
        map2.put("Kimya", 90);

        int cem = 0;

        for (int deyer : map2.values()) {
            cem = cem + deyer;
        }

        double orta = (double) cem / map2.size();

        System.out.println("Ortalama: " + orta);
    }
}
