package az.developia.spring_project_14aprel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import az.developia.spring_project_14aprel.entity.User;
import jakarta.persistence.QueryHint;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM users", nativeQuery = true)
    long countAllUsers();

    @Query("SELECT COUNT(u) FROM User u")
    long countUsersJPQL();

    @QueryHints({ @QueryHint(name = "org.hibernate.flushMode", value = "MANUAL") })
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmailJPQL(@Param("email") String email);
}