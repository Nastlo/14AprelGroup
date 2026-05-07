package az.developia.spring_project_14aprel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import az.developia.spring_project_14aprel.entity.Home;

@SpringBootApplication
public class SpringProject14aprelApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(SpringProject14aprelApplication.class, args);

        Home home1 = context.getBean(Home.class);
        Home home2 = context.getBean(Home.class);

        System.out.println(home1);
        System.out.println(home2);

        System.out.println(home1 == home2);
    }

}