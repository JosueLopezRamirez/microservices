package com.josuedevcode.inventory_service.dto.request;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderItemRequest(
        Long id,
        String sku,
        BigDecimal price,
        Long quantity
) {
}
