package io.erenkaya.akaldiroglu._08_example.awareness.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String name() {
        return "GOOD_NAME";
    }
}
