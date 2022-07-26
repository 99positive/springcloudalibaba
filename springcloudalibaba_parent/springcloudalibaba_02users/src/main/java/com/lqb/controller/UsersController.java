package com.lqb.controller;

import com.lqb.feignclients.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Date 2022/7/27 0:22
 * @Create by lqb
 */
@RestController
@Slf4j
public class UsersController {

    @Value("${server.port}")
    private int port;

    @Autowired
    private DiscoveryClient discoveryClient; //服务发现客户端

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("users")
    public String users() {
        String name = "users";
        log.info("users ! alibaba {}", port);
        // 无法负载均衡，路径不好维护
//        String forObject = new RestTemplate().getForObject("http://localhost:8992/products", String.class);
//        log.info("result: {}", forObject);

        //ribbon 1.已引入依赖（自带） 2.实现负载均衡 DiscoveryClient LoadBalanceClient
//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("PRODUCTS");
//        for (ServiceInstance serviceInstance : serviceInstanceList) {
//            log.info("服务主机：{}，服务端口：{}，服务uri：{}", serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri());
//        }
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCTS");
//        String forObject = new RestTemplate().getForObject(serviceInstance.getUri() + "/products", String.class);

//        String forObject = restTemplate.getForObject("http://PRODUCTS/products", String.class);
        String forObject = productClient.products();
        return name + " " + port + forObject;
    }
}
