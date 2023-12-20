package com.example.cruddesafio02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruddesafio02.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
