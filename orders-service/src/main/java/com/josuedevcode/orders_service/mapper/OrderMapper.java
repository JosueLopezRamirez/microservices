package com.josuedevcode.orders_service.mapper;

import com.josuedevcode.orders_service.dto.request.OrderRequest;
import com.josuedevcode.orders_service.dto.response.OrderResponse;
import com.josuedevcode.orders_service.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "items", source = "order.orderItems")
    OrderResponse toResponse(Order order);
    Order toEntity(OrderRequest order);
}
