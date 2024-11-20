package com.ehelper.admin.controller;

import com.ehelper.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getuser(@PathVariable int id){
        //call the service by url directly
        //User user= restTemplate.getForObject("http://127.0.0.1:9001/user/1",User.class);

        //call the service by eureka
        List<ServiceInstance> instances = discoveryClient.getInstances("user_services");
        ServiceInstance serviceInstance = instances.get(0);
        User user= restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()
                +"/user/1",User.class);
        return user;
    }}