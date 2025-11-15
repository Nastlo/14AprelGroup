package lesson7;
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Gun nomresini daxil edin (1-7): ");
        int gunNomresi = input.nextInt();

        switch (gunNomresi) {
            case 1:
                System.out.println("Bazar ertesi");
                break;
            case 2:
                System.out.println("Çərşənbə axşamı");
                break;
            case 3:
                System.out.println("Çərşənbə");
                break;
            case 4:
                System.out.println("Cümə axşamı");
                break;
            case 5:
                System.out.println("Cümə");
                break;
            case 6:
                System.out.println("Şənbə");
                break;
            case 7:
                System.out.println("Bazar");
                break;
            default:
                System.out.println("Yanlış nomre daxil etdiniz! (1-7 arası olmalıdır)");
        }

        input.close();

	}

}
