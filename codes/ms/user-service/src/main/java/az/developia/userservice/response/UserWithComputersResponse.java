package az.developia.userservice.response;

import java.util.List;

import az.developia.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithComputersResponse {

    private User user;
    private List<Object> computers;
}