package com.example.reactiveclient.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HttpClients {
    @Bean
    WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
