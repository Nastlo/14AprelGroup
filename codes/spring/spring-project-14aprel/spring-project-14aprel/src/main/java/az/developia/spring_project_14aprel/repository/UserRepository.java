package az.developia.spring_project_14aprel.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import az.developia.spring_project_14aprel.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM users", nativeQuery = true)
    long countAllUsers();
}