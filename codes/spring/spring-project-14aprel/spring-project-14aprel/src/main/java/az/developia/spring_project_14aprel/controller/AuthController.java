package az.developia.spring_project_14aprel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import az.developia.spring_project_14aprel.entity.User;
import az.developia.spring_project_14aprel.repository.UserRepository;
import az.developia.spring_project_14aprel.requestdto.LoginRequestDto;
import az.developia.spring_project_14aprel.responsedto.LoginResponseDto;
import az.developia.spring_project_14aprel.security.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody LoginRequestDto loginRequest) {

        User user = userRepository.findByUsername(
                loginRequest.getUsername()
        );

        if (user == null) {
            throw new RuntimeException(
                    "Username və ya password yanlışdır"
            );
        }

        if (!passwordEncoder.matches(
                loginRequest.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Username və ya password yanlışdır"
            );
        }

        String token = jwtService.generateToken(
                user.getUsername(),
                user.getAuthority()
        );

        return new LoginResponseDto(token);
    }
}