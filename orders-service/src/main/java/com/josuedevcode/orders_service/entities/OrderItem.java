package com.josuedevcode.orders_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private BigDecimal price;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
