package com.openpay.marvelapi.consumer.repository;

import com.openpay.marvelapi.consumer.model.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, UUID> {
}
