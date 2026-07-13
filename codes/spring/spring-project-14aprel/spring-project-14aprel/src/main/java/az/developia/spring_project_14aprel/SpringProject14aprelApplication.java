package az.developia.spring_project_14aprel;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import az.developia.spring_project_14aprel.entity.Order;
import az.developia.spring_project_14aprel.entity.User;
import az.developia.spring_project_14aprel.repository.UserRepository;

@SpringBootApplication
public class SpringProject14aprelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProject14aprelApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return args -> {

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

            System.out.println("İstifadəçi və sifarişlər əlavə edildi.");

            userRepository.delete(user);

            System.out.println("İstifadəçi silindi.");
            System.out.println("Cascade sayəsində sifarişlər də silindi.");
        };
    }
}