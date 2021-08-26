package com.bao.fruit.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String token;
}
