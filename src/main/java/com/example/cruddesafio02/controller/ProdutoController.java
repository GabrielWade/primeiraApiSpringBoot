package com.example.cruddesafio02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddesafio02.model.ProdutoModel;
import com.example.cruddesafio02.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> obterTodos(){
        return produtoService.obterTodos();
    }

    @GetMapping("/categoria/{categoriaNome}")
        public List<ProdutoModel> obterPorCategoria(@PathVariable String categoriaNome){
        return produtoService.obterPorCategoria(categoriaNome);
    }

    @GetMapping("/{id}")
    public ProdutoModel obterPorId(@PathVariable Long id){

        return produtoService.obterPorId(id);
    }

    @PostMapping
    public ProdutoModel Adicionar(@RequestBody ProdutoModel produto){
        return produtoService.adicionar(produto);
    }   

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produto){
        return produtoService.atualizar(id, produto);
    }  
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        produtoService.deletar(id);
    }
}
