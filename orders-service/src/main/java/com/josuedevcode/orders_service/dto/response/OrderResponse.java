package com.josuedevcode.orders_service.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderResponse(
        Long id,
        String orderNumber,
        List<OrderItemResponse> items
) {
}
