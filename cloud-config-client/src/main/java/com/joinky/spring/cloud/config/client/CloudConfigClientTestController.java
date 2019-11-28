package com.joinky.spring.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CloudConfigClientTestController {

    @Value("${name.fable}")
    private String name;

    @Value("${version}")
    private String version;

    @RequestMapping("config")
    public String gitConfig() {
        return name + ": " + version;
    }
}
