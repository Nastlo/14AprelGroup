package az.developia.spring_project_14aprel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import az.developia.spring_project_14aprel.entity.User;
import az.developia.spring_project_14aprel.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/count")
    public long countAllUsers() {
        return userService.countAllUsers();
    }

    @GetMapping("/count-jpql")
    public long countUsersJPQL() {
        return userService.countUsersJPQL();
    }

    @GetMapping(value = "/email", produces = {"application/json","application/xml"})
    public User findByEmail(@RequestParam String email) {
        return userService.findByEmailJPQL(email);
    }
} 