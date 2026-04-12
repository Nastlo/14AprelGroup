package lesson42;

import java.io.*;


public class Main {
    public static void main(String[] args) {

        try {
            File folder = new File("myFolder");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File file = new File("myFolder/qeyd.txt");

            if (file.exists()) {
                System.out.println("Fayl artıq var");
            } else {
                file.createNewFile();

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("Java-da fayllarla işləmək maraqlıdır!");

                bw.close();
                fw.close();

                System.out.println("Fayl yaradıldı və yazıldı");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}