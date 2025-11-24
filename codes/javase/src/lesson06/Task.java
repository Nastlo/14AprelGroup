package lesson06;
public class Task {
    public static void main(String[] args) {

        // -----------------------------
        // TAPŞIRIQ 1
        // -----------------------------

        int a = 10;
        int b = 3;

        int cem = a + b;
        int ferq = a - b;
        int hasil = a * b;
        int bolme = a / b;
        int qaliq = a % b;

        System.out.println("Cəm: " + cem);
        System.out.println("Fərq: " + ferq);
        System.out.println("Hasil: " + hasil);
        System.out.println("Bölmə: " + bolme);
        System.out.println("Qalıq: " + qaliq);



        // -----------------------------
        // TAPŞIRIQ 2
        // -----------------------------


        int x = 5;
        int y = 8;

        System.out.println("x == y : " + (x == y));
        System.out.println("x != y : " + (x != y));
        System.out.println("x < y  : " + (x < y));
        System.out.println("x > y  : " + (x > y));
        System.out.println("x <= y : " + (x <= y));
        System.out.println("x >= y : " + (x >= y));



        // -----------------------------
        // TAPŞIRIQ 3
        // -----------------------------

        boolean s = true;
        boolean t = false;

        System.out.println("s && t : " + (s && t)); 
        System.out.println("s || t : " + (s || t)); 
        System.out.println("!s : " + (!s));         
        System.out.println("!t : " + (!t));         
    }
}
