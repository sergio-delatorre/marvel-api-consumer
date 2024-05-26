package com.openpay.marvelapi.consumer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String message;
    private String details;
}