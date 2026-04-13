package lesson43;


import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            File folder = new File("student_data");
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("Qovluq yaradıldı.");
            } else {
                System.out.println("Qovluq artıq mövcuddur.");
            }


            File file = new File("student_data/info.txt");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Fayl yaradıldı.");
            } else {
                System.out.println("Fayl artıq mövcuddur.");
            }


            Scanner scanner = new Scanner(System.in);

            System.out.print("Ad daxil et: ");
            String ad = scanner.nextLine();

            System.out.print("Soyad daxil et: ");
            String soyad = scanner.nextLine();

            System.out.print("Yaş daxil et: ");
            String yas = scanner.nextLine();


            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("Ad: " + ad + "\n");
            writer.write("Soyad: " + soyad + "\n");
            writer.write("Yaş: " + yas + "\n");
            writer.close();

            System.out.println("Məlumat fayla yazıldı.");


            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("\nFayldan oxunan məlumat:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();


            System.out.print("\nFaylı silmək istəyirsən? (bəli/xeyr): ");
            String cavab = scanner.nextLine();

            if (cavab.equalsIgnoreCase("bəli")) {
                if (file.delete()) {
                    System.out.println("Fayl silindi.");
                } else {
                    System.out.println("Fayl silinmədi.");
                }

                if (folder.delete()) {
                    System.out.println("Qovluq da silindi.");
                } else {
                    System.out.println("Qovluq silinmədi (boş olmaya bilər).");
                }
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }
}