package com.example.reactiveclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/WebClient")
public class WebClientController {
    @Autowired
    WebClient.Builder builder;

    @RequestMapping("/Hello")
    public Mono<String> getHello() {

        return builder.baseUrl("http://localhost:8080/Test/Hello")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);

    }

    @RequestMapping(value = "/Upstream/mock/execute", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> testUpstreamWith200msEndpoint() {

        return builder
                .baseUrl("http://localhost:8080/Test/mockUpstream/200/execute")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);

    }

    @RequestMapping(value = "/Upstream/mock/400/execute", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> testUpstreamWith400msEndpoint() {

        return builder
                .baseUrl("http://localhost:8080/Test/mockUpstream/400/execute")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);

    }

    @RequestMapping(value = "/Upstream/mock/800/execute", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> testUpstreamWith800msEndpoint() {

        return builder
                .baseUrl("http://localhost:8080/Test/mockUpstream/800/execute")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);

    }

    @RequestMapping(value = "/Upstream/mock/2000/execute", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> testUpstreamWith2000msEndpoint() {

        return builder
                .baseUrl("http://localhost:8080/Test/mockUpstream/2000/execute")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);

    }


    @RequestMapping(value = "/Upstream/mock/execute/status404",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> testUpstreamwith404Status(){

        return builder
                .baseUrl("http://localhost:8080/Test/mockUpstream/200/execute/404")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);

    }

    @RequestMapping(value = "/Upstream/mock/execute/status500",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> testUpstreamwith500Status(){

        return builder
                .baseUrl("http://localhost:8080/Test/mockUpstream/200/execute/500")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);

    }

    @RequestMapping(value = "/Upstream/mock/execute/status503",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> testUpstreamwith503Status(){

        return builder
                .baseUrl("http://localhost:8080/Test/mockUpstream/200/execute/503")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);

    }
}