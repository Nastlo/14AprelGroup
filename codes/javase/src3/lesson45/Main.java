package lesson45;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Task 1
        System.out.println("TASK 1 - Yalnız rəqəmlər yoxlanışı");

        System.out.print("Bir string daxil et: ");
        String input = sc.nextLine();

        boolean onlyDigits = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (!Character.isDigit(ch)) {
                onlyDigits = false;
                break;
            }
        }

        System.out.println("Nəticə: " + onlyDigits);

        // Task 2
        System.out.println("\nTASK 2 - Tarix formatı yoxlanışı");

        System.out.print("Tarix daxil et (dd-mm-yyyy): ");
        String date = sc.nextLine();

        boolean isValid = true;

        if (date.length() != 10) {
            isValid = false;
        } else {
            if (date.charAt(2) != '-' || date.charAt(5) != '-') {
                isValid = false;
            } else {
                String dayStr = date.substring(0, 2);
                String monthStr = date.substring(3, 5);
                String yearStr = date.substring(6);

                if (!dayStr.matches("\\d\\d") ||
                    !monthStr.matches("\\d\\d") ||
                    !yearStr.matches("\\d\\d\\d\\d")) {
                    isValid = false;
                } else {
                    int day = Integer.parseInt(dayStr);
                    int month = Integer.parseInt(monthStr);

                    if (day < 1 || day > 31) {
                        isValid = false;
                    }

                    if (month < 1 || month > 12) {
                        isValid = false;
                    }
                }
            }
        }

        System.out.println("Nəticə: " + isValid);
    }
}
