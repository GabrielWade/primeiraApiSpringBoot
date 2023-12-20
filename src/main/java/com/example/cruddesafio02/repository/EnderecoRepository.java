package com.example.cruddesafio02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruddesafio02.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
