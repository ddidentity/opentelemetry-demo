package com.example.otel.service;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class HiThereClient
{
    private final RestTemplate _restTemplate;

    HiThereClient(RestTemplate restTemplate)
    {
        _restTemplate = restTemplate;
    }
    public void callDependentApp()
    {
        introduceRandomDelay();
        _restTemplate.getForObject("http://localhost:8888/hi-there", String.class);
        introduceRandomDelay();
    }

    public void introduceRandomDelay() {
        Random random = new Random();
        int delay = random.nextInt(1000); // Generate a random number between 0 and 999 milliseconds
        try {
            Thread.sleep(delay); // Introduce the delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interrupted exception
        }
    }

}
