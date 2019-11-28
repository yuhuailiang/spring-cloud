package com.eureka.application.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumptionService {

    @Value("${app.service.url}")
    public String appServiceUrl;

    @Autowired
    public RestTemplate restTemplate;

    public String callService(String type) {
        ResponseEntity result = restTemplate.postForEntity(
                appServiceUrl + "getService/" + type, null, String.class);
        return result.getBody().toString();
    }
}
