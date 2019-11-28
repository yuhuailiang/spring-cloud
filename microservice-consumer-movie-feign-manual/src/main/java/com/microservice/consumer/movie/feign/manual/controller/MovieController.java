package com.microservice.consumer.movie.feign.manual.controller;

import com.microservice.consumer.movie.feign.manual.entity.User;
import com.microservice.consumer.movie.feign.manual.service.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

/**
 * @author Joinky
 */
@RestController
@Slf4j
@Import(FeignClientsConfiguration.class)
public class MovieController {

    private UserFeignClient userFeignClient;

    private UserFeignClient adminFeignClient;

    public MovieController(Decoder decoder, Encoder encoder, Client client,
                           Contract contract) {
        this.userFeignClient = Feign.builder().client(client).encoder(encoder)
                .decoder(decoder).contract(contract).requestInterceptor(
                        new BasicAuthRequestInterceptor("user", "password1"))
                .target(UserFeignClient.class, "http://microservice-provider-user/");
        this.adminFeignClient = Feign.builder().client(client).encoder(encoder)
                .decoder(decoder).contract(contract).requestInterceptor(
                        new BasicAuthRequestInterceptor("admin", "password2"))
                .target(UserFeignClient.class, "http://microservice-provider-user/");
    }

    @GetMapping("/user/{id}")
    public User findByIdUser(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/admin/{id}")
    public User findByIdAdmin(@PathVariable Long id) {
        return this.adminFeignClient.findById(id);
    }
}
