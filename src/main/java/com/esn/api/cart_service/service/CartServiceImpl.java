package com.esn.api.cart_service.service;

import com.esn.api.cart_service.dao.CartRepository;
import com.esn.api.cart_service.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;
    @Override
    public CartItem addItem(CartItem item) {
        if (item == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item cannot be null");
        }
        return cartRepository.save(item);
    }

    @Override
    public List<CartItem> getAllItems() {
        return cartRepository.findAll();
    }

    @Override
    public CartItem getItemById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteItem(Long id) {
        cartRepository.deleteById(id);
    }
}
