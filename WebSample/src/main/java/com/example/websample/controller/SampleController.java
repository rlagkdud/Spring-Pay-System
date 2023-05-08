package com.example.websample.controller;

import com.example.websample.dto.ErrorResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String id) throws IllegalAccessException {
        log.info("Get some order information: " + id);
        if ("500".equals(id)) {
            throw new IllegalAccessException("500 is not valid order.");
        }
        return "orderId:" + id;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(IllegalAccessException.class)
    public ErrorResponse handleIllegalAccessException(IllegalAccessException e){
        log.error("IllegalAccessException is occurred", e);
        return new ErrorResponse("INVALIDE_ACCESS","IllegalAccessException is occurred");
    }

    @DeleteMapping("/order/{orderId}")
    public String deleteOrder(@PathVariable("orderId") String id) {
        log.info("delete order: " + id);
        return "delete orderId:" + id;
    }

    @GetMapping("/order")
    public String getOrderWitRequestParam(
            @RequestParam(value = "orderId", required = false, defaultValue = "defaultId") String id,
            @RequestParam("orderAmount") Integer amount) {
        log.info("Get order id: " + id + ", amount: " + amount);
        return "orderId:" + id + ", orderAmount:" + amount;
    }

    @PostMapping("/order")
    public String createOrder(
            @RequestBody CreateOrderRequest createOrderRequest,
            @RequestHeader String userAccountId) {
        log.info("createOrderReq: " + createOrderRequest +
                ", userAccountId: " + userAccountId);
        return "orderId:" + createOrderRequest.getOrderId() +
                ", orderAmount:" + createOrderRequest.getOrderAmount();
    }

    @PutMapping("/order")
    public String createOrder() {
        log.info("Create order");
        return "order created -> orderId:1, orderAmount:1000";
    }

    @Data
    public static class CreateOrderRequest {
        private String orderId;
        private Integer orderAmount;

    }
}
