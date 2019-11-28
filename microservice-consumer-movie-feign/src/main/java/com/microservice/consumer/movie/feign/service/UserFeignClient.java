package com.microservice.consumer.movie.feign.service;

import com.microservice.consumer.movie.feign.config.FeignClientFallback;
import com.microservice.consumer.movie.feign.config.FeignLogConfig;
import com.microservice.consumer.movie.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Joinky
 * @since 2019-11-28
 * 增加fallback，支持hystrix熔断
 * 使用FeignClientFallback类
 */
@FeignClient(name = "microservice-provider-user", fallback = FeignClientFallback.class)
public interface UserFeignClient {

    /**
     * @javadoc
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
