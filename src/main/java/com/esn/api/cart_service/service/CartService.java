package com.esn.api.cart_service.service;

import com.esn.api.cart_service.model.CartItem;

import java.util.List;

public interface CartService {
    CartItem addItem(CartItem item);
    List<CartItem> getAllItems();
    CartItem getItemById(Long id);
    void deleteItem(Long id);
}
