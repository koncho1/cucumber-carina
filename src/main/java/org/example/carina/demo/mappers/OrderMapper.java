package org.example.carina.demo.mappers;

import org.example.carina.demo.models.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getOrdersByUserId(int userId);
}
