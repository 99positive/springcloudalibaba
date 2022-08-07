package com.lqb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/8/7 17:26
 * @Create by lqb
 */
@RestController
@RequestMapping("/demo/")
@Slf4j
public class DemoController {

    @Value("${server.port}")
    private String port;

    @GetMapping("test")
    public String demo(){
        log.info("test {}", port);
        return "test";
    }
}
