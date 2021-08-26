package com.bao.fruit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bao.fruit.mapper")
public class FruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruitApplication.class, args);
    }

}
