package com.bakshi.reactive.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Configuration
public class BaseConfiguration {
    
    Logger logger = LoggerFactory.getLogger(BaseConfiguration.class);

@Bean(name = "testClient")
public WebClient getWebClient(){
    return WebClient.builder().baseUrl("https://httpbin.org").filters(exchangeFilterFunctions -> {
        exchangeFilterFunctions.add(logRequest());
        exchangeFilterFunctions.add(logResponse());
    }).build();
}

public ExchangeFilterFunction logRequest() {
    return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            StringBuilder sb = new StringBuilder("Request: \n");
            //append clientRequest method and url
            clientRequest
              .headers()
              .forEach((name, values) -> values.forEach(value -> sb.append(value)));
              logger.info(sb.toString());
        return Mono.just(clientRequest);
    });
}

 public ExchangeFilterFunction logResponse() {
    return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            StringBuilder sb = new StringBuilder("Response: \n")
              .append("Status: ")
              .append(clientResponse.rawStatusCode());
            clientResponse
              .headers()
              .asHttpHeaders()
              .forEach((key, value1) -> value1.forEach(value -> sb
                .append("\n")
                .append(key)
                .append(":")
                .append(value)));
            logger.info(sb.toString());
        return Mono.just(clientResponse);
    });
}
}
