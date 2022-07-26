package com.lqb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/7/27 0:16
 * @Create by lqb
 */
@RestController
@Slf4j
public class ProductsController {

    @Value("${server.port}")
    private int port;

    @GetMapping("products")
    public String products() {
        String name = "products";
        log.info("products ! alibaba {}", port);
        return name + " " + port;
    }
}
