package az.developia.userservice.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import az.developia.userservice.entity.User;
import az.developia.userservice.repository.UserRepository;
import az.developia.userservice.response.UserWithComputersResponse;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserWithComputersResponse getUserWithComputers(Integer userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        Map response = restTemplate.getForObject(
                "http://localhost:8081/computers/user/" + userId,
                Map.class
        );

        List<Object> computers = response == null
                ? Collections.emptyList()
                : (List<Object>) response.get("computers");

        return new UserWithComputersResponse(user, computers);
    }
}