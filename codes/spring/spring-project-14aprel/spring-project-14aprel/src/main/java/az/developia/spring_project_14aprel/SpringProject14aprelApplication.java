package az.developia.spring_project_14aprel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.spring_project_14aprel.entity.Person;

@SpringBootApplication
public class SpringProject14aprelApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(SpringProject14aprelApplication.class, args);

        Person person = context.getBean(Person.class);

        context.close();
    }
}
