package com.josuedevcode.orders_service.services;

import com.josuedevcode.orders_service.dto.request.OrderRequest;
import com.josuedevcode.orders_service.dto.response.BaseResponse;
import com.josuedevcode.orders_service.dto.response.OrderResponse;
import com.josuedevcode.orders_service.entities.Order;
import com.josuedevcode.orders_service.mapper.OrderItemMapper;
import com.josuedevcode.orders_service.mapper.OrderMapper;
import com.josuedevcode.orders_service.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderMapper orderMapper;
    private final WebClient.Builder webClientBuilder;

    @Transactional
    public void placeOrder(OrderRequest request){

        // check for inventory
        BaseResponse result = webClientBuilder.build()
                .post()
                .uri("lb://inventory-service/api/inventory/in-stock")
                .bodyValue(request.orderItems())
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();

        if(result != null && !result.hasErrors()){
            var order = new Order();
            order.setOrderNumber((UUID.randomUUID().toString()));
            order.setOrderItems(
                    request.orderItems().stream().map(
                            item -> orderItemMapper.toEntity(item, order)
                    ).toList());

            orderRepository.save(order);
        }else{
            throw new IllegalArgumentException("some of the products are not in stock");
        }
    }

    public List<OrderResponse> getAllOrders(){
        var orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::toResponse).toList();
    }
}
