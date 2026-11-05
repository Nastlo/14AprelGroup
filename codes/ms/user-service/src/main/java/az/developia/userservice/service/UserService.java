
package az.developia.userservice.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import az.developia.userservice.entity.User;
import az.developia.userservice.event.UserEvent;
import az.developia.userservice.repository.UserRepository;
import az.developia.userservice.response.ComputerListResponse;
import az.developia.userservice.response.ComputerResponse;
import az.developia.userservice.response.UserWithComputersResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {

        User savedUser = userRepository.save(user);

        UserEvent event = new UserEvent(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getAge()
        );

        rabbitTemplate.convertAndSend(
                "user.created.queue",
                event.toString()
        );

        return savedUser;
    }

    @CircuitBreaker(
            name = "computerService",
            fallbackMethod = "computerServiceFallback"
    )
    public UserWithComputersResponse getUserWithComputers(Integer userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        ComputerListResponse response = restTemplate.getForObject(
                "http://computer-service/computers/user/" + userId,
                ComputerListResponse.class
        );

        List<ComputerResponse> computers = response == null
                ? List.of()
                : response.getComputers();

        return new UserWithComputersResponse(user, computers);
    }

    public UserWithComputersResponse computerServiceFallback(
            Integer userId, Throwable exception) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        return new UserWithComputersResponse(user, List.of());
    }
}
