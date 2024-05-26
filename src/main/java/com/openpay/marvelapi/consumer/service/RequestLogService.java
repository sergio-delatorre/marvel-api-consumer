package com.openpay.marvelapi.consumer.service;

import com.openpay.marvelapi.consumer.model.entity.RequestLog;

import java.util.List;

/**
 * Interfaz que define los métoodos asociados a los logs de servicios usados.
 */
public interface RequestLogService {

    /**
     * Obtiene todos los logs de servicios.
     *
     * @return Una lista de objetos {@link RequestLog} con el path y hora de ejecución de los servicios.
     */
    List<RequestLog> getAll();
}
