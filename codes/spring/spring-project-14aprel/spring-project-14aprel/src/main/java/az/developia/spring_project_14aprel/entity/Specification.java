package az.developia.spring_project_14aprel.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "specifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpu;
    private Integer ram;
    private Integer storage;

    @OneToOne(mappedBy = "specification", fetch = FetchType.EAGER)
    private Computer computer;
}