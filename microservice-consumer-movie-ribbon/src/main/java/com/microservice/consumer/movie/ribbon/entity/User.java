package com.microservice.consumer.movie.ribbon.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {

    private Long id;

    private String userName;

    private String name;

    private Integer age;

    private BigDecimal balance;

}
