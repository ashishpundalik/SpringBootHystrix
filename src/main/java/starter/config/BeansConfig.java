package starter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ashishpundalik on 08/11/2017.
 */
@Configuration
public class BeansConfig {

    @Bean
    @Lazy
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
