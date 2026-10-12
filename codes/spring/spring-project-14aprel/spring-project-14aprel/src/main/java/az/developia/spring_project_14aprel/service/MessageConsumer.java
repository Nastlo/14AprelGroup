
package az.developia.spring_project_14aprel.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14aprel.config.RabbitMQConfig;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("RabbitMQ gelen mesaj: " + message);
    }
}
