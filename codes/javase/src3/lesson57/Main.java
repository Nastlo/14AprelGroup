package lesson57;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        String product = "Car";
        Optional.ofNullable(product)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Məhsul tapılmadı")
                );

        String phone = null;
        Optional.ofNullable(phone)
                .filter(p -> !p.isEmpty())
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Nömrə daxil edilməyib")
                );

        Integer age = null;
        System.out.println(Optional.ofNullable(age).orElse(18));
    }
}