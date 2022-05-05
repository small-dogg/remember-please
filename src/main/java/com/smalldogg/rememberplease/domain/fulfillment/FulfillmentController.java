package com.smalldogg.rememberplease.domain.fulfillment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Slf4j
public class FulfillmentController {

    @PostMapping("/save")
    public String getTest(){
        log.info("yea!!!");
        return "hello";
    }
}
