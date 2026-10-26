package az.developia.userservice.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import az.developia.userservice.entity.User;
import az.developia.userservice.repository.UserRepository;
import az.developia.userservice.response.ComputerListResponse;
import az.developia.userservice.response.ComputerResponse;
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

        ResponseEntity<ComputerListResponse> response =
                restTemplate.exchange(
                        "http://localhost:8081/computers/user/" + userId,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ComputerListResponse>() {}
                );

        ComputerListResponse computerListResponse = response.getBody();

        List<ComputerResponse> computers =
                computerListResponse == null
                        ? List.of()
                        : computerListResponse.getComputers();

        return new UserWithComputersResponse(user, computers);
    }
}