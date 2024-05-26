package com.openpay.marvelapi.consumer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "service_request_log")
public class ServiceRequestLog extends Auditable {

    @Column(nullable = false)
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
