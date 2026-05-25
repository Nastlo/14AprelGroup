package az.developia.spring_project_14aprel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.spring_project_14aprel.config.AppConfig;

@SpringBootApplication
public class SpringProject14aprelApplication {

    private static final Logger logger =
            LoggerFactory.getLogger(SpringProject14aprelApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(SpringProject14aprelApplication.class, args);

        AppConfig bean = run.getBean(AppConfig.class);

    }
}