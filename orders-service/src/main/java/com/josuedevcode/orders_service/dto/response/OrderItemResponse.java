package com.josuedevcode.orders_service.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderItemResponse(
        Long id,
        String sku,
        BigDecimal price,
        Long quantity
) {
}
