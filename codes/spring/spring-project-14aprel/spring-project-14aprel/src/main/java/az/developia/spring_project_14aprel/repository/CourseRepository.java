package az.developia.spring_project_14aprel.repository;

import az.developia.spring_project_14aprel.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByNameContainingIgnoreCase(String name);

    List<Course> findByTeacherNameContainingIgnoreCase(String teacherName);

    Optional<Course> findByName(String name);

    List<Course> findByCredit(int credit);

    List<Course> findByCreditBetween(int minCredit, int maxCredit);

    @Query("SELECT c FROM Course c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Course> searchByName(@Param("name") String name);

    @Query("SELECT c FROM Course c WHERE c.credit >= :credit")
    List<Course> findCoursesWithCreditGreaterThan(@Param("credit") int credit);

    @Query("SELECT c FROM Course c WHERE c.teacherName = :teacherName")
    List<Course> findCoursesByTeacher(@Param("teacherName") String teacherName);

    @Query("SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT COUNT(c) FROM Course c")
    long countCourses();

    @Query(value = "SELECT * FROM courses WHERE credit >= :credit", nativeQuery = true)
    List<Course> findByCreditNative(@Param("credit") int credit);

    @Query(value = "SELECT * FROM courses WHERE teacher_name LIKE CONCAT('%', :teacherName, '%')", nativeQuery = true)
    List<Course> searchByTeacherNative(@Param("teacherName") String teacherName);

    @Query(value = "SELECT COUNT(*) FROM courses", nativeQuery = true)
    long countCoursesNative();
}