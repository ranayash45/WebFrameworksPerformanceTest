package com.example.reactiveclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/RestPublisher")
public class PublisherRestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/Hello")
    public String GetHello() {
        return "Hello World";
    }

    @RequestMapping("/mock/upstream/Hello")
    public Mono<String> GetHelloFromUpstream() {
        return Mono.fromCallable(() -> {
            return restTemplate.exchange("http://localhost:8080/Test/Hello",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class).getBody();
        }).publishOn(Schedulers.elastic());

    }

    @RequestMapping("/mock/upstream/execute")
    public Mono<String> executeUpstreamWith200ms() {
        return Mono.fromCallable(() -> {
            return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class).getBody();
        }).publishOn(Schedulers.elastic());
    }

    @RequestMapping("/mock/upstream/400/execute")
    public Mono<String> executeUpstreamWith400ms() {

        return Mono.fromCallable(() -> {
            return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/400/execute",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class).getBody();
        }).publishOn(Schedulers.elastic());

    }

    @RequestMapping("/mock/upstream/800/execute")
    public Mono<String> executeUpstreamWith800ms() {

        return Mono.fromCallable(() -> {
            return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/800/execute",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class).getBody();
        }).publishOn(Schedulers.elastic());

    }

    @RequestMapping("/mock/upstream/2000/execute")
    public Mono<String> executeUpstreamWith2000ms() {

        return Mono.fromCallable(() -> {
            return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/2000/execute",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class).getBody();
        }).publishOn(Schedulers.elastic());


    }

    @RequestMapping("/mock/upstream/200/execute/404")
    public Mono<String> executeUpstreamWith404Status() {

        return Mono.fromCallable(() -> {
            return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/404",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class).getBody();
        }).publishOn(Schedulers.elastic());

    }

    @RequestMapping("/mock/upstream/200/execute/500")
    public Mono<String> executeUpstreamWith500Status() {

        return Mono.fromCallable(() -> {
            return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/500",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class).getBody();
        }).publishOn(Schedulers.elastic());
    }

    @RequestMapping("/mock/upstream/200/execute/503")
    public Mono<String> executeUpstreamWith503Status() {

        return Mono.fromCallable(() -> {
            return restTemplate.exchange("http://localhost:8080/Test/mockUpstream/200/execute/503",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class).getBody();
        }).publishOn(Schedulers.elastic());

    }
}
