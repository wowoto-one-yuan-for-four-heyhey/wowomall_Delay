package com.xmu.wowoto.delay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DelayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelayApplication.class, args);
    }

}
