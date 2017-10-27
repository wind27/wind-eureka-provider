package com.wind.eureka.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * HelloController
 *
 * @author qianchun 17/10/9
 **/
@RefreshScope
@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String name;

//    @Value("${user.jdbc.driverClassName}")
    @Value("${user.jdbc.username}")
    private String driverClassName;

    @RequestMapping(value = "/user/provider")
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
        return name+"-"+port + ":"+driverClassName;
    }
}
