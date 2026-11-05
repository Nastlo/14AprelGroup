
package az.developia.computerservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    @RabbitListener(queues = "user.created.queue")
    public void receiveUserEvent(String message) {

        System.out.println("New User Event Received:");
        System.out.println(message);
    }
}
