package com.openpay.marvelapi.consumer.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

    @NotBlank(message = "Email cannot be blank")
    @Email(regexp = ValidationRegex.EMAIL_REGEX, message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Pattern(regexp = ValidationRegex.PASSWORD_REGEX, message = "Invalid password format")
    private String password;
}
