package com.example.reactiveclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Rest")
public class RestTemplateController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/Hello")
    public String GetHello(){
        return "Hello World";
    }
    @RequestMapping("/mock/upstream/Hello")
    public String GetHelloFromUpstream(){
        return restTemplate.exchange("http://localhost:8080/Test/Hello",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class).getBody();

    }

    @RequestMapping("/mock/upstream/execute")
    public String executeUpstreamWith200ms(){
        return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class).getBody();

    }

    @RequestMapping("/mock/upstream/400/execute")
    public String executeUpstreamWith400ms(){

        return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/400/execute",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class).getBody();

    }

    @RequestMapping("/mock/upstream/800/execute")
    public String executeUpstreamWith800ms(){

        return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/800/execute",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class).getBody();

    }

    @RequestMapping("/mock/upstream/2000/execute")
    public String executeUpstreamWith2000ms(){

        return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/2000/execute",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class).getBody();

    }

    @RequestMapping("/mock/upstream/200/execute/404")
    public String executeUpstreamWith404Status(){

        return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/404",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class).getBody();

    }

    @RequestMapping("/mock/upstream/200/execute/500")
    public String executeUpstreamWith500Status(){

        return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/500",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class).getBody();

    }

    @RequestMapping("/mock/upstream/200/execute/503")
    public String executeUpstreamWith503Status(){

        return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/503",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class).getBody();

    }

}
