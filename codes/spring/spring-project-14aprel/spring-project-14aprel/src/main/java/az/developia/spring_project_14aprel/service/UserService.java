package az.developia.spring_project_14aprel.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import az.developia.spring_project_14aprel.entity.User;
import az.developia.spring_project_14aprel.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {

        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            return "Bu username artıq mövcuddur!";
        }

        userRepository.save(user);

        return "Qeydiyyat uğurla tamamlandı";
    }

    public long countAllUsers() {
        return userRepository.countAllUsers();
    }
}