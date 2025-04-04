package com.josuedevcode.inventory_service.services;

import com.josuedevcode.inventory_service.dto.request.OrderItemRequest;
import com.josuedevcode.inventory_service.dto.response.BaseResponse;
import com.josuedevcode.inventory_service.entities.Inventory;
import com.josuedevcode.inventory_service.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String sku){
        var inventory = inventoryRepository.findBySku(sku);
        return inventory.filter(value -> value.getQuantity() > 0).isPresent();
    }

    public BaseResponse areInStock(List<OrderItemRequest> orderItems){

        var errorList = new ArrayList<String>();

        List<String> skus = orderItems.stream().map(OrderItemRequest::sku).toList();
        List<Inventory> inventoryList = inventoryRepository.findBySkuIn(skus);

        orderItems.forEach(orderItem -> {
            var inventory = inventoryList.stream().filter(value -> value.getSku().equals(orderItem.sku())).findFirst();
            if(inventory.isEmpty()){
                errorList.add("Product with sku " + orderItem.sku() + " does not exist");
            } else if (inventory.get().getQuantity() < orderItem.quantity()) {
                errorList.add("Product with sku " + orderItem.sku() + " does insufficient quantity");
            }
        });

        return !errorList.isEmpty() ? BaseResponse.builder()
                .errorMessages(errorList.toArray(new String[0]))
                .build() : BaseResponse.builder().errorMessages(null).build();
    }
}
