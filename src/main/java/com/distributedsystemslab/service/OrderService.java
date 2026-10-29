package com.distributedsystemslab.service;

import com.distributedsystemslab.dto.CreateOrderRequest;
import com.distributedsystemslab.dto.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public OrderResponse createOrder(CreateOrderRequest request){
        if(request.getProductId()==null || request.getQuantity()==null || request.getQuantity()<=0){
            throw new IllegalArgumentException("Please specify proper product id or quantity");
        }
        OrderResponse response = new OrderResponse(2L,request.getProductId(),"Order created");
        return response;
    }
}
