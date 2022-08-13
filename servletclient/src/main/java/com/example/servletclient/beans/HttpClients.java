package com.example.servletclient.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClients {

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
