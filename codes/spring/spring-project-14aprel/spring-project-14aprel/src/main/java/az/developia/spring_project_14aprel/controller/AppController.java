package az.developia.spring_project_14aprel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.spring_project_14aprel.config.AppConfig;

@Controller
public class AppController {

    @Autowired
    private AppConfig appConfig;

    @GetMapping("/app")
    public String showAppInfo(Model model) {

        model.addAttribute("name", appConfig.getName());
        model.addAttribute("version", appConfig.getVersion());

        return "app";
    }
}