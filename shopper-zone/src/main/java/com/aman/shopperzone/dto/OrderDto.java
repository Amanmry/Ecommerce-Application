package com.aman.shopperzone.dto;

import com.aman.shopperzone.enums.OrderStatus;
import com.aman.shopperzone.model.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class OrderDto {
    private Long id;
    private Long UserId;
    private LocalDate orderDate;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private Set<OrderItemDto> items;
}
