package az.developia.spring_project_14aprel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String teacherName;

    @Min(1)
    @Max(10)
    private int credit;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}