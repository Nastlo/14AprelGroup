package az.developia.computerservice.event;

import java.io.Serializable;

public record UserEvent(
        Integer id,
        String firstName,
        String lastName,
        Integer age
) implements Serializable {
}