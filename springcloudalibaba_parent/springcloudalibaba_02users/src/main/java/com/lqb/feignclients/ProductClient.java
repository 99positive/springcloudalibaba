package com.lqb.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Date 2022/7/27 1:02
 * @Create by lqb
 */
@FeignClient("PRODUCTS")
public interface ProductClient {

    @GetMapping("/products")
    String products();
}
