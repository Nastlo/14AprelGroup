package lesson16;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        char[] simvolMassivi = {
                'J','a','v','a','D','e','v','e','l','o',
                'p','e','r','2','0','2','5','!','!','?','*'
        };

        String stringDeyisen = new String(simvolMassivi);
        System.out.println("1. Nəticə: " + stringDeyisen);


        String setir2 = "Abc";
        boolean yoxlama = setir2.matches("[a-zA-Z]{3}");
        System.out.println("2. 3 simvol və ingilis əlifbasıdır: " + yoxlama);


        String setir3 = "";
        boolean bosdur = setir3.isEmpty();
        System.out.println("3. Sətir boşdur: " + bosdur);


        boolean bitir = bitirmi("JavaDeveloper", "Developer");
        System.out.println("4. Sətir verilən dəyərlə bitir: " + bitir);


        Random random = new Random();
        int tesadufiEded = random.nextInt(21) + 10;
        System.out.println("5. Təsadüfi ədəd: " + tesadufiEded);


        double kesrEded = 12.34567;
        double yuvarlaq = Math.round(kesrEded * 100.0) / 100.0;
        System.out.println("6. Yuvarlaqlaşdırılmış ədəd: " + yuvarlaq);
    }


    public static boolean bitirmi(String setir1, String setir2) {
        return setir1.endsWith(setir2);
    }
}
