package com.aman.shopperzone.service.order;

import com.aman.shopperzone.model.Order;

import java.util.List;

public interface IOrderService {

    Order placeOrder(Long userId);

    Order getOrder(Long orderId);

    List<Order> getUserOrders(Long userId);
}
