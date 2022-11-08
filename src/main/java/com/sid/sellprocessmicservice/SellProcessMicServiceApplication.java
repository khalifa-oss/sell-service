package com.sid.sellprocessmicservice;

import com.sid.sellprocessmicservice.model.Customer;
import com.sid.sellprocessmicservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class SellProcessMicServiceApplication  {
    @Autowired

    public static void main(String[] args) {
        SpringApplication.run( SellProcessMicServiceApplication.class, args );
    }


    @Bean
    CommandLineRunner start(RepositoryRestConfiguration repositoryRestConfiguration,CustomerRepository customerRepository){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor( Customer.class );
            List<Customer> listCustomer =List.
                    of( new Customer( null, "jhon", "jhon@gmail.com" ), new Customer( null, "mohamed", "mohamed@gmail.com" ) );
//        Iterable<Customer> itr= (Iterable<Customer>) list.iterator();
            customerRepository.saveAll( listCustomer );


        };
    }
}
