package com.example.websample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    @RequestMapping(value = "/order/1", method = RequestMethod.GET)
    public String getOrder(){
        log.info("Get some order");
        return "orderId:1, orderAmount:1000";
    }
}
