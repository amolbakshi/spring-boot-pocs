package com.bakshi.reactive.demo.controller;

import com.bakshi.reactive.demo.model.Car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController("/controller")
public class SampleController {
    
Logger logger = LoggerFactory.getLogger(SampleController.class);

@Autowired(required = true)
WebClient webClient;

@GetMapping("simpleGet")
public Mono<String> getSimpleResponse(){
    
    Mono<String> response =  webClient.get().uri("/get").retrieve().bodyToMono(String.class);
    logger.info("Printed before response");
    return response;
}


@GetMapping("getCar")
public Mono<Car> getCar(){
    Car car = new Car("Accura","TL","2021", 100);
    Mono<Car> response =  webClient.post().uri("anything")
    .body(Mono.just(car),Car.class)
    .retrieve().bodyToMono(Car.class);
    logger.info("Printed before response");
    return response;
}

}
