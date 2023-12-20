package com.example.cruddesafio02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import com.example.cruddesafio02.model.ProdutoModel;

//Devemos colocar esse @ para indicar que essa classe é um repositório
//Como estou erdando essa classe do JPA, não preciso colocar @Repository
//quando faço isso, eu estou injetando uma dependencia no spring, ou seja adicionar uma quadradinho numa caixa de sapato
//@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    List<ProdutoModel> findByCategoria_Nome(String nome);
}
