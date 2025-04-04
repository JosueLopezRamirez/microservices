package com.josuedevcode.product_service.services;

import com.josuedevcode.product_service.dto.request.ProductRequest;
import com.josuedevcode.product_service.dto.response.ProductResponse;
import com.josuedevcode.product_service.entities.Product;
import com.josuedevcode.product_service.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(ProductRequest request) {
        var product = Product.builder()
                .sku(request.sku())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .status(request.status())
                .build();
        productRepository.save(product);
        log.info("Product added: {}", product);
    }

    public List<ProductResponse> getAllProducts() {
        var products = productRepository.findAll();

        return products.stream().map(this::maptoProductResponse).toList();
    }

    private ProductResponse maptoProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .description(product.getDescription())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }
}
