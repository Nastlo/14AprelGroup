package az.developia.spring_project_14aprel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.spring_project_14aprel.config.AppConfig;

@SpringBootApplication
public class SpringProject14aprelApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext run = SpringApplication.run(SpringProject14aprelApplication.class, args);	
		 AppConfig bean = run.getBean(AppConfig.class);
		 bean.showAppInfo();
	}
	
	
	
}
