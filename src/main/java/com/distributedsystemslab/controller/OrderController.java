package com.distributedsystemslab.controller;

import com.distributedsystemslab.dto.CreateOrderRequest;
import com.distributedsystemslab.dto.OrderResponse;
import com.distributedsystemslab.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        OrderResponse orderResponse;
        try {
            orderResponse = orderService.createOrder(createOrderRequest);
        }
        catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderResponse,HttpStatus.CREATED);
    }
}
