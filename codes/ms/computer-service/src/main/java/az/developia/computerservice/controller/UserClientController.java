package az.developia.computerservice.controller;

import az.developia.computerservice.service.UserClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientController {

    private final UserClientService userClientService;

    public UserClientController(UserClientService userClientService) {
        this.userClientService = userClientService;
    }

    @GetMapping("/users-from-service")
    public String getUsers() {
        return userClientService.getUsers();
    }
}