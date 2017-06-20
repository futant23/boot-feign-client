/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.boot.feign.client;

import com.company.boot.feign.client.service.GreetingClient;
import com.company.boot.feign.client.service.ToppingsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class FeignApplication {
    
    @Autowired
    private GreetingClient greetingClient;
    
    @Autowired
    private ToppingsInterface toppingsClient;
 
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
    
    @RequestMapping("/get-toppings")
    public String[] getToppings() {
        return toppingsClient.toppings();
    }
 
    @RequestMapping("/get-greeting")
    public String greeting() {
        return greetingClient.greeting();
    }
}
