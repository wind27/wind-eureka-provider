package com.wind.eureka.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * HelloController
 *
 * @author qianchun 17/10/9
 **/
@RestController(value = "user")
public class HelloController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/provider")
    public String hello(){
        System.out.println("eureka 服务提供者!!!");

        //输出服务信息
        List<String> services = client.getServices();
        if(CollectionUtils.isEmpty(services)) {
            return "false";
        }

        System.out.println("-------------------------------------------");
        for(String key : services) {
            List<ServiceInstance> instances = client.getInstances(key);
            if(CollectionUtils.isEmpty(instances)) {
                continue;
            }
            for(ServiceInstance instance : instances) {
                System.out.println("uri={"+instance.getUri()+"}，serviceId={"+instance.getServiceId()+"}");
            }
        }
        System.out.println("-------------------------------------------");
        return "wind-eureka-provider";
    }
}
