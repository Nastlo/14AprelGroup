package az.developia.spring_project_14aprel.requestdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateRequest {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Min(15)
    @Max(70)
    private int age;

    @NotBlank
    @Email
    private String email;
}