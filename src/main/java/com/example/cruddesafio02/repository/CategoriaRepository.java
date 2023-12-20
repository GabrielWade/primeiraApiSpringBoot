package com.example.cruddesafio02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruddesafio02.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
