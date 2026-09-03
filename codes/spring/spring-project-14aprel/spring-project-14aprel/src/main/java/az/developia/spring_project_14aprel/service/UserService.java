package az.developia.spring_project_14aprel.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14aprel.entity.Order;
import az.developia.spring_project_14aprel.entity.User;
import az.developia.spring_project_14aprel.exception.ResourcesNotFoundException;
import az.developia.spring_project_14aprel.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @CacheEvict(value = {"users", "countAllUsers", "countUsersJPQL"}, allEntries = true)
    public String register(User user) {

        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            return "Bu username artıq mövcuddur!";
        }

        userRepository.save(user);

        return "Qeydiyyat uğurla tamamlandı";
    }

    @Cacheable("countAllUsers")
    public long countAllUsers() {
        System.out.println("MySQL-dən oxundu (countAllUsers)");
        return userRepository.countAllUsers();
    }

    public void cascadeExample() {

        User user = new User();
        user.setFirstName("Ömər");
        user.setLastName("Cəfərli");
        user.setUsername("omer");
        user.setPassword("1234");
        user.setEmail("omer@gmail.com");

        Order order1 = new Order();
        order1.setOrderDate(LocalDate.now());
        order1.setTotalPrice(100.0);
        order1.setStatus("Hazırlanır");
        order1.setUser(user);

        Order order2 = new Order();
        order2.setOrderDate(LocalDate.now());
        order2.setTotalPrice(200.0);
        order2.setStatus("Göndərildi");
        order2.setUser(user);

        Order order3 = new Order();
        order3.setOrderDate(LocalDate.now());
        order3.setTotalPrice(300.0);
        order3.setStatus("Çatdırıldı");
        order3.setUser(user);

        user.setOrders(List.of(order1, order2, order3));

        userRepository.save(user);

        System.out.println("İstifadəçi və 3 sifariş əlavə edildi.");
        System.out.println("İstifadəçi silindi.");
        System.out.println("Cascade sayəsində sifarişlər də silindi.");
    }

    @Cacheable("countUsersJPQL")
    public long countUsersJPQL() {
        System.out.println("MySQL-dən oxundu (countUsersJPQL)");
        return userRepository.countUsersJPQL();
    }

    @Cacheable(value = "users", key = "#email")
    public User findByEmailJPQL(String email) {
        System.out.println("MySQL-dən oxundu (findByEmail)");
        return userRepository.findByEmailJPQL(email);
    }

    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourcesNotFoundException("İstifadəçi tapılmadı. ID = " + id));
    }
}