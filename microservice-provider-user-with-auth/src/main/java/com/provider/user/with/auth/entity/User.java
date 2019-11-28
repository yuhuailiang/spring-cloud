package com.provider.user.with.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "USERNAME")
    public String userName;

    @Column(name = "NAME")
    public String name;

    @Column(name = "AGE")
    public Integer age;

    @Column(name = "BALANCE")
    public BigDecimal balance;

}
