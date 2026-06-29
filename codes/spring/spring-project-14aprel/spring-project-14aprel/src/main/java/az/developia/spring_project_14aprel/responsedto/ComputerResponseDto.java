package az.developia.spring_project_14aprel.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComputerResponseDto {

    private Integer id;
    private String brand;
    private String model;
}