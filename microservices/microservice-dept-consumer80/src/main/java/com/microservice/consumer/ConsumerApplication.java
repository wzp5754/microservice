package com.microservice.consumer;

import com.microservice.robinrule.ConSumerRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICE-DEPT",configuration = ConSumerRobinRule.class)
public class ConsumerApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
