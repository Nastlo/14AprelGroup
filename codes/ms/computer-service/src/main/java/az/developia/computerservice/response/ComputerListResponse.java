package az.developia.computerservice.response;

import java.util.List;

import az.developia.computerservice.entity.Computer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComputerListResponse {

    private List<Computer> computers;
}