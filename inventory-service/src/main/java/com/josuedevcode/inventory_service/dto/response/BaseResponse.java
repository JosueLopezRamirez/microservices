package com.josuedevcode.inventory_service.dto.response;

import lombok.Builder;

@Builder
public record BaseResponse(
        String[] errorMessages
) {

    public boolean hasErrors(){
        return errorMessages != null && errorMessages.length > 0;
    }
}
