package com.udea.edu.co.microservices.accounting.repository;

import com.udea.edu.co.microservices.accounting.entities.EventMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventMessagessRepository extends JpaRepository<EventMessage, String> {

}
