package com.eureka.application.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CosumptionController {

    @Autowired
    public ConsumptionService consumptionService;

    @GetMapping("getService")
    public String comsuption(String type) {
        String result = consumptionService.callService(type);
        return result;
    }
}
