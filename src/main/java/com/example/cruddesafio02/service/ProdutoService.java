package com.example.cruddesafio02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddesafio02.model.ProdutoModel;
import com.example.cruddesafio02.model.exception.ResourceNotFoundException;
import com.example.cruddesafio02.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public ProdutoModel adicionar(ProdutoModel produto){
        return produtoRepository.save(produto);
    }

    public List<ProdutoModel> obterTodos(){
        return produtoRepository.findAll();
    }

    public List<ProdutoModel> obterPorCategoria(String nome){
        return produtoRepository.findByCategoria_Nome(nome);
    }

    public ProdutoModel obterPorId(Long id){
        return produtoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));
        
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produto){
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }
}
