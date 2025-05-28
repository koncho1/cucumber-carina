package org.example.carina.demo.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private int orderId;
    private int userId;
    private String productName;
    private String price;
}
