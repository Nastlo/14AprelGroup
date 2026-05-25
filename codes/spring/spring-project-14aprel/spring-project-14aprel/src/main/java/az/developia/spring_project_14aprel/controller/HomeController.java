package az.developia.spring_project_14aprel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.spring_project_14aprel.config.AppConfig;

@Controller
public class HomeController {
	
	private Logger log = LoggerFactory.getLogger(AppConfig.class);

    @GetMapping("/hello")
    public String Home() {
    	log.info("api işe düşdü");
    	return "hello";
    }

}