package com.openpay.marvelapi.consumer.controller;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;
import com.openpay.marvelapi.consumer.model.dto.UserRequest;
import com.openpay.marvelapi.consumer.model.dto.UserResponse;
import com.openpay.marvelapi.consumer.security.JwtTokenProvider;
import com.openpay.marvelapi.consumer.service.MarvelService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controlador REST para manejar solicitudes relacionadas con los usuarios.
 * Provee endpoints para la creación de nuevos usuarios y la generación de tokens JWT.
 * <p>
 * Incluye los siguientes endpoints
 * <ul>
 * 	<li> Registro de Usuario
 * </ul>
 *
 * @author Sergio de la Torre
 * @see UserRequest
 * @see UserResponse
 * @see JwtTokenProvider
 * @version 1.0
 * @since 2024-05-26
 */
@RestController
@RequestMapping("/users")
@Api(tags = "Users")
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * Endpoint para registrar un nuevo usuario.
     *
     * @param userRequest El objeto {@link UserRequest} que contiene la información del usuario a registrar.
     * @return Un objeto {@link ResponseEntity} que contiene el {@link UserResponse} con el email del usuario y el token generado.
     */
    @ApiOperation(value = "Sign up a new user", notes = "Creates a new user and returns a JWT token")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created user"),
            @ApiResponse(code = 400, message = "Invalid user request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "userRequest",
                    value = "User object that needs to be sign up",
                    example = "{ \"email\": \"example@domain.com\", \"password\": \"qCYgPz#@cwG7\" }",
                    required = true,
                    dataType = "UserRequest",
                    paramType = "body"
            )
    })
    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> signUp(@RequestBody @Valid UserRequest userRequest){
        UserResponse userResponse = UserResponse.builder()
                .email(userRequest.getEmail())
                .token(jwtTokenProvider.generateToken())
                .build();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
