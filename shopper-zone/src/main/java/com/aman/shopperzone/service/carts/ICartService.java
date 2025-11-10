package com.aman.shopperzone.service.carts;

import com.aman.shopperzone.model.Cart;
import com.aman.shopperzone.model.User;

import java.math.BigDecimal;

public interface ICartService {

    Cart getCart(Long id);

    void clearCart(Long id);

    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
