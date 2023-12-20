package com.example.cruddesafio02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cruddesafio02.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    List<ProdutoModel> findByCategoria_Nome(String nome);
}
