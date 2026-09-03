package az.developia.spring_project_14aprel.repository;

import az.developia.spring_project_14aprel.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameContainingIgnoreCase(String name);

    List<Student> findByLastNameContainingIgnoreCase(String name);

    Optional<Student> findByEmail(String email);

    List<Student> findByAgeBetween(int minAge, int maxAge);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT s FROM Student s WHERE LOWER(s.firstName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> searchByName(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> findStudentsOlderThan(@Param("age") int age);

    @Query("SELECT s FROM Student s WHERE s.age <= :age")
    List<Student> findStudentsYoungerThan(@Param("age") int age);

    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.name = :courseName")
    List<Student> findStudentsByCourseName(@Param("courseName") String courseName);

    @Query("SELECT s FROM Student s WHERE s.email = :email")
    Optional<Student> findStudentByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM students WHERE age >= :age", nativeQuery = true)
    List<Student> findByAgeNative(@Param("age") int age);

    @Query(value = "SELECT * FROM students WHERE first_name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<Student> searchByNameNative(@Param("name") String name);

    @Query(value = "SELECT COUNT(*) FROM students", nativeQuery = true)
    long countStudentsNative();

    Page<Student> findAll(Pageable pageable);
}