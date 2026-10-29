package com.distributedsystemslab.service;


import com.distributedsystemslab.dto.CreateOrderRequest;
import com.distributedsystemslab.dto.OrderResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderServiceTest {



    @Test
    public void testOrderCreation(){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setProductId("PRODUCT-101");
        request.setQuantity(2);

        OrderService orderService = new OrderService();
        OrderResponse response = orderService.createOrder(request);


        assertEquals(response.productId(),request.getProductId());
    }

    @Test
    public void testOrderCreationError1(){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setProductId("PRODUCT-101");
        request.setQuantity(0);

        OrderService orderService = new OrderService();
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.createOrder(request);
        });
    }

    @Test
    public void testOrderCreationError2(){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setProductId("PRODUCT-101");
        request.setQuantity(null);

        OrderService orderService = new OrderService();
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.createOrder(request);
        });
    }

    @Test
    public void testOrderCreationError3(){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setProductId("PRODUCT-101");
        request.setQuantity(-2);

        OrderService orderService = new OrderService();
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.createOrder(request);
        });
    }
}
