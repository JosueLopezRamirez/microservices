package com.josuedevcode.orders_service.controllers;

import com.josuedevcode.orders_service.dto.request.OrderRequest;
import com.josuedevcode.orders_service.dto.response.OrderResponse;
import com.josuedevcode.orders_service.services.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderRequest request){
        orderService.placeOrder(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
    }
}
