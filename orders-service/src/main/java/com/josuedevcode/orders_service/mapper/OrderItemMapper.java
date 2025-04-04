package com.josuedevcode.orders_service.mapper;

import com.josuedevcode.orders_service.dto.request.OrderItemRequest;
import com.josuedevcode.orders_service.dto.response.OrderItemResponse;
import com.josuedevcode.orders_service.entities.Order;
import com.josuedevcode.orders_service.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemResponse toResponse(OrderItem orderItem);

    @Mapping(target = "id", source = "orderItemRequest.id")
    OrderItem toEntity(OrderItemRequest orderItemRequest, Order order);
}
