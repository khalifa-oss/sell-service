package com.sid.sellprocessmicservice.feigninterface;

import com.sid.sellprocessmicservice.model.PojoExample;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;


@FeignClient(name = "demo.feign",url="https://gorest.co.in/")
public interface FeignPojoExample {
    @GetMapping(path="/public-api/users")
    String findAll();

}
