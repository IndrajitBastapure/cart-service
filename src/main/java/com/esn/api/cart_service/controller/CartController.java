package com.esn.api.cart_service.controller;

import com.esn.api.cart_service.model.CartItem;
import com.esn.api.cart_service.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private static final Logger logger = LogManager.getLogger(CartController.class);
    @Autowired
    private CartService cartService;
    @Operation(summary = "Add an item to the cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/add")
    public ResponseEntity<CartItem> addItemToCart(@Valid @RequestBody CartItem item) {
        logger.info("Adding item to cart: {}", item);
        CartItem newItem = cartService.addItem(item);
        return ResponseEntity.ok(newItem);
    }
    @Operation(summary = "Get all items in the cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all items successfully")
    })
    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getAllItems() {
        logger.info("Fetching all items from the cart");
        List<CartItem> items = cartService.getAllItems();
        return ResponseEntity.ok(items);
    }
    @Operation(summary = "Get item by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Item not found")
    })
    @GetMapping("/item/{id}")
    public ResponseEntity<CartItem> getItemById(@PathVariable Long id) {
        logger.info("Fetching item with id: {}", id);
        CartItem item = cartService.getItemById(id);
        return ResponseEntity.ok(item);
    }
    @Operation(summary = "Delete an item from the cart")
    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Item deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Item not found") })
    @DeleteMapping("/item/{id}") public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        logger.info("Deleting item with id: {}", id);
        cartService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
