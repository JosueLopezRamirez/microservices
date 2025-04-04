package com.josuedevcode.product_service.controllers;

import com.josuedevcode.product_service.dto.request.ProductRequest;
import com.josuedevcode.product_service.dto.response.ProductResponse;
import com.josuedevcode.product_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest request){
        productService.addProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

}
