package com.sid.sellprocessmicservice.model;

import org.springframework.data.rest.core.config.Projection;

@Projection( name="cust",types = Customer.class)
public interface CustomerProjection {
    public Long getId();
    public String getName();
    public String getEmail();
}
