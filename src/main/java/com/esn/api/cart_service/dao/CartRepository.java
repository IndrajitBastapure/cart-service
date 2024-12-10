package com.esn.api.cart_service.dao;

import com.esn.api.cart_service.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
