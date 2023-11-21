package com.user.user.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced  // it will help to load balance and it will call direct application name not hostip or port
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
