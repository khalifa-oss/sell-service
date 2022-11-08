package com.sid.sellprocessmicservice.repository;

import com.sid.sellprocessmicservice.model.PojoExample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PojoRepository extends JpaRepository<PojoExample,Long> {
}
