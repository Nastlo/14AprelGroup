package az.developia.spring_project_14aprel.entity;

import org.springframework.stereotype.Component;

@Component
public class Computer {

    private String brand;

    public Computer() {

        this.brand = "Asus";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}