
package az.developia.computerservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue userCreatedQueue() {
        return new Queue("user.created.queue", true);
    }
}
