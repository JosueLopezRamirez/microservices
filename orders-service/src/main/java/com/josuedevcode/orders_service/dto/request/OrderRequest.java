package com.josuedevcode.orders_service.dto.request;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderRequest(
        List<OrderItemRequest> orderItems
) {
}
