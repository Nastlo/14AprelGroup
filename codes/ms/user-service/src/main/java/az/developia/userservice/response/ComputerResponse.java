package az.developia.userservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComputerResponse {

    private Integer id;
    private String brand;
    private String model;
    private Double price;
    private Integer userId;
}