package com.example.otel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
    private final com.example.otel.service.HiThereClient _hiThereClient;
    HelloWorldController(com.example.otel.service.HiThereClient hiThereClient)
    {
        _hiThereClient = hiThereClient;
    }

    @GetMapping("/hello-world")
    public String helloTraces()
    {
        _hiThereClient.callDependentApp();
        log.info("Hello World");
        return "Hello World";
    }

}
