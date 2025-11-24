package lesson07;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        System.out.print("Yaşınızı daxil edin: "); 
        int yas = input.nextInt(); 

        if (yas < 18) { 
            System.out.println("Access denied"); 
        } else { 
            System.out.println("Access granted"); 
        }

        input.close(); 
    }
}
