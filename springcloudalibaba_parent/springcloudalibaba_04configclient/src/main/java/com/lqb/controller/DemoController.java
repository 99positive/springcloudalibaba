package com.lqb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/7/27 23:59
 * @Create by lqb
 */
@Slf4j
@RestController
@RefreshScope // 允许 远端配置修改
public class DemoController {

    @Value("${Demo.username}")
    private String userName;

    @GetMapping("/demo")
    public String demo() {
        log.info("demo:" + userName);
        return "demo ok !!! userName:" + userName;
    }
}
