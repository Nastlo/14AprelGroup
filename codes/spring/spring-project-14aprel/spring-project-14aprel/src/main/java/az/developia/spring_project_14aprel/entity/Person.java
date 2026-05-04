package az.developia.spring_project_14aprel.entity;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Person {

    public Person() {
        System.out.println("Person nesnesi oluşturuldu.");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("init metodu çalıştı.");
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("destroy metodu çalıştı.");
    }
}
