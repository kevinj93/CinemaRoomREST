package cinema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaConfig {
    @Bean
    public Room returnRoom () {
        return new Room(9,9);
    }
}
