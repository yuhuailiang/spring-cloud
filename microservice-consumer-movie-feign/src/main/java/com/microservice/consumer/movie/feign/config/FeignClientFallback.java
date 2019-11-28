package com.microservice.consumer.movie.feign.config;

import com.microservice.consumer.movie.feign.entity.User;
import com.microservice.consumer.movie.feign.service.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Joinky
 */
@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setAge(20);
        user.setUserName("default");
        user.setName("默认用户");
        return user;
    }
}
