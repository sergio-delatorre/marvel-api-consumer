package com.openpay.marvelapi.consumer.repository;

import com.openpay.marvelapi.consumer.model.entity.ServiceRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceRequestLogRepository extends JpaRepository<ServiceRequestLog, UUID> {
}
