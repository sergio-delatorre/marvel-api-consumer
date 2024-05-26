package com.openpay.marvelapi.consumer.controller;

import com.openpay.marvelapi.consumer.model.entity.RequestLog;
import com.openpay.marvelapi.consumer.service.RequestLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para manejar solicitudes relacionadas con los logs de servicios.
 * <p>
 * Incluye los siguientes endpoints
 * <ul>
 * 	<li> Obtener lista de todos los logs
 * </ul>
 *
 * @author Sergio de la Torre
 * @see RequestLog
 * @see RequestLogService
 * @version 1.0
 * @since 2024-05-26
 */
@RestController
@RequestMapping("/request-logs")
@Api(tags = "Request Log")
public class RequestLogController {

    private final RequestLogService requestLogService;

    @Autowired
    public RequestLogController(RequestLogService requestLogService) {
        this.requestLogService = requestLogService;
    }

    /**
     * Obtiene todos los logs de solicitudes.
     *
     * @return Una lista de objetos {@link RequestLog} que tienen la información del path y hora de las solicitudes
     */
    @GetMapping()
    @ApiOperation("Get all request logs.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of request logs retrieved successfully"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public List<RequestLog> getRequestLogs() {
        return requestLogService.getAll();
    }
}
