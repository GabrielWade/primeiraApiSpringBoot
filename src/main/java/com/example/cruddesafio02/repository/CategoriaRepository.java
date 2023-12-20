package com.example.cruddesafio02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruddesafio02.model.Categoria;
//import org.springframework.stereotype.Repository;

//Devemos colocar esse @ para indicar que essa classe é um repositório
//Como estou erdando essa classe do JPA, não preciso colocar @Repository
//quando faço isso, eu estou injetando uma dependencia no spring, ou seja adicionar uma quadradinho numa caixa de sapato
//@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
