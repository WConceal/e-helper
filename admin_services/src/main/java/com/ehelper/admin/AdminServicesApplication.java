package com.ehelper.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EntityScan("com.ehelper.admin.entity")
//Only valid to Eureka &can not found dependency class
//@EnableEurekaClient

//valid to muti register platform
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class AdminServicesApplication {
    //add ribbon
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(AdminServicesApplication.class,args);
    }
}
