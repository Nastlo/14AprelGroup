package az.developia.spring_project_14aprel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import az.developia.spring_project_14aprel.service.UserService;

@SpringBootApplication
@EnableCaching
public class SpringProject14aprelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProject14aprelApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.cascadeExample();
        };
    }
}