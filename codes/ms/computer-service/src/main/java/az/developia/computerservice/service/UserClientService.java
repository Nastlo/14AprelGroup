package az.developia.computerservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserClientService {

    private final RestTemplate restTemplate;

    public UserClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getUsers() {
        return restTemplate.getForObject(
            "http://user-service/users",
            String.class
        );
    }
}