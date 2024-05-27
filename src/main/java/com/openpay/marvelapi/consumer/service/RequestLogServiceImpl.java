package com.openpay.marvelapi.consumer.service;

import com.openpay.marvelapi.consumer.model.entity.RequestLog;
import com.openpay.marvelapi.consumer.repository.RequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestLogServiceImpl implements  RequestLogService{

    private RequestLogRepository requestLogRepository;

    @Autowired
    public RequestLogServiceImpl(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }

    @Override
    public List<RequestLog> getAll() {
        return requestLogRepository.findAll();
    }
}
