package lesson48;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TASK 1
        System.out.print("Decimal eded daxil et: ");
        int decimal = sc.nextInt();

        String binary = Integer.toBinaryString(decimal);
        String octal = Integer.toOctalString(decimal);
        String hex = Integer.toHexString(decimal);

        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hex);

        // TASK 2
        System.out.print("Binary eded daxil et: ");
        String binaryInput = sc.next();

        int decimalResult = Integer.parseInt(binaryInput, 2);

        System.out.println("Decimal: " + decimalResult);

        // TASK 3
        System.out.print("Birinci ededi daxil et: ");
        int a = sc.nextInt();

        System.out.print("Ikinci ededi daxil et: ");
        int b = sc.nextInt();

        System.out.println("AND: " + (a & b));
        System.out.println("OR: " + (a | b));
        System.out.println("XOR: " + (a ^ b));

        System.out.print("Eded (n) daxil et: ");
        int n = sc.nextInt();

        System.out.print("Shift miqdari (m) daxil et: ");
        int m = sc.nextInt();

        System.out.println("n << m: " + (n << m));
        System.out.println("n >> m: " + (n >> m));

        sc.close();
    }
}