package lesson47;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Binary ədəd daxil et: ");
        String binary = sc.nextLine();
        int decimalFromBinary = Integer.parseInt(binary, 2);

        System.out.print("Hexadecimal ədəd daxil et: ");
        String hex = sc.nextLine();
        int decimalFromHex = Integer.parseInt(hex, 16);

        System.out.println("Binary -> Decimal: " + decimalFromBinary);
        System.out.println("Hexadecimal -> Decimal: " + decimalFromHex);
    }
}
