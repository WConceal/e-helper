package com.ehelper.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@EntityScan("com.ehelper.user.entity")
//Only valid to Eureka &can not found dependency class
//@EnableEurekaClient

//valid to muti register platform
@EnableDiscoveryClient
public class UserServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServicesApplication.class,args);
    }
}
