package com.esn.api.cart_service.controller;

import com.esn.api.cart_service.model.CartItem;
import com.esn.api.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody CartItem item) {
        CartItem newItem = cartService.addItem(item);
        return ResponseEntity.ok(newItem);
    }
    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getAllItems() {
        List<CartItem> items = cartService.getAllItems();
        return ResponseEntity.ok(items);
    }
    @GetMapping("/item/{id}")
    public ResponseEntity<CartItem> getItemById(@PathVariable Long id) {
        CartItem item = cartService.getItemById(id);
        return ResponseEntity.ok(item);
    }
    @DeleteMapping("/item/{id}") public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        cartService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
