package com.openpay.marvelapi.consumer.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String email;
    private String token;
}
