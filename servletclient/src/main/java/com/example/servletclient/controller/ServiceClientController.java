package com.example.servletclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Client")
public class ServiceClientController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/Hello")
    public String getHello(){
        return "Hello World";
    }
    @RequestMapping("/Upstream/Hello")
    public String testHelloEndpoint() {
        String data = restTemplate.exchange("http://localhost:8080/Test/Hello",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }

    @RequestMapping(value = "/Upstream/mock/execute",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testUpstreamWith200msEndpoint() {

        String data = restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }

    @RequestMapping(value = "/Upstream/mock/400/execute",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testUpstreamWith400msEndpoint() {

        String data = restTemplate.exchange("http://localhost:8080/Test/mockUpstream/400/execute",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }

    @RequestMapping(value = "/Upstream/mock/600/execute",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testUpstreamWith600msEndpoint() {

        String data = restTemplate.exchange("http://localhost:8080/Test/mockUpstream/600/execute",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }
    @RequestMapping(value = "/Upstream/mock/800/execute",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testUpstreamWith800msEndpoint() {

        String data = restTemplate.exchange("http://localhost:8080/Test/mockUpstream/800/execute",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }

    @RequestMapping(value = "/Upstream/mock/2000/execute",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testUpstreamWith2000msEndpoint() {

        String data = restTemplate.exchange("http://localhost:8080/Test/mockUpstream/2000/execute",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }

    @RequestMapping(value = "/Upstream/mock/execute/status404",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testUpstreamwith404Status(){
        String data = restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/404",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }

    @RequestMapping(value = "/Upstream/mock/execute/status500",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testUpstreamwith500Status(){
        String data = restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/500",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }

    @RequestMapping(value = "/Upstream/mock/execute/status503",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testUpstreamwith503Status(){
        String data = restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/503",
                HttpMethod.GET,
                RequestEntity.EMPTY,
                String.class).getBody();

        return data;
    }


}
