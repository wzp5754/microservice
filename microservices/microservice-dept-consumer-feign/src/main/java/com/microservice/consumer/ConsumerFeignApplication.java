package com.microservice.consumer;

import com.microservice.robinrule.ConSumerRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.microservice.service"})
@ComponentScan("com.microservice.service")
public class ConsumerFeignApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsumerFeignApplication.class,args);
    }
}
