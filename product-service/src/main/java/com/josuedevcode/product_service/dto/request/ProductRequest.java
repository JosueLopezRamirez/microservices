package com.josuedevcode.product_service.dto.request;

import lombok.Builder;
import java.math.BigDecimal;

@Builder
public record ProductRequest(
        String sku,
        String name,
        String description,
        BigDecimal price,
        Boolean status
) {
}
