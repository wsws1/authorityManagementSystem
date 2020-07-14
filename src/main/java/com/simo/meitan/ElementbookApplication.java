package com.simo.meitan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.simo.meitan"})
@MapperScan(basePackages = {"com.simo.meitan.mapper"})
public class ElementbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElementbookApplication.class, args);
    }

}
