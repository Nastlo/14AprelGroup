package az.developia.spring_project_14aprel.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Home implements InitializingBean, DisposableBean {

    private int id;
    private String address;
    private String color;

    // Default constructor
    public Home() {
        this.id = 1;
        this.address = "Baku";
        this.color = "White";

        System.out.println("Home object yaradildi");
    }

    // Getter and Setter metodlari

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // init method
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }

    // destroy method
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public String toString() {
        return "Home [id=" + id + ", address=" + address + ", color=" + color + "]";
    }
}