package com.distributedsystemslab.dto;


public class CreateOrderRequest {

    private String productId;
    private Integer quantity;

    public String getProductId(){
        return this.productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
