package com.microservice.consumer.movie.feign.custom.service;

import com.microservice.consumer.movie.feign.custom.configure.FeignConfiguration;
import com.microservice.consumer.movie.feign.custom.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Tyler
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 根据id查询用户信息
     * @param id
     * @return User
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
