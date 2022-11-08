package com.sid.sellprocessmicservice.repository;

import com.sid.sellprocessmicservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RepositoryRestResource (path = "customer")
public interface CustomerRepository  extends JpaRepository<Customer,Long> {
    @RestResource(path = "/byId")
    Customer findCustomerById(@Param("id" ) Long id);





}
