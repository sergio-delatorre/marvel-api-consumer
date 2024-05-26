package com.openpay.marvelapi.consumer.controller;

import com.openpay.marvelapi.consumer.model.dto.UserRequest;
import com.openpay.marvelapi.consumer.model.dto.UserResponse;
import com.openpay.marvelapi.consumer.security.JwtTokenProvider;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Api(tags = "Users")
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest userRequest){
        UserResponse userResponse = UserResponse.builder()
                .email(userRequest.getEmail())
                .token(jwtTokenProvider.generateToken())
                .build();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
