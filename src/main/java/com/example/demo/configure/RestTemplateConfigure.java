package com.example.demo.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author panfuxue
 * @date 2022/02/06 21:05
 */
@Configuration
public class RestTemplateConfigure {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
