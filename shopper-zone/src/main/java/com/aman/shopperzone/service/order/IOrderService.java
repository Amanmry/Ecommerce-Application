package com.aman.shopperzone.service.order;

import com.aman.shopperzone.dto.OrderDto;
import com.aman.shopperzone.model.Order;

import java.util.List;

public interface IOrderService {

    Order placeOrder(Long userId);

    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
