package az.developia.spring_project_14aprel.requestdto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String teacherName;

    @Min(1)
    @Max(10)
    private int credit;
}