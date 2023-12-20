package com.example.cruddesafio02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddesafio02.model.Categoria;
import com.example.cruddesafio02.model.exception.ResourceNotFoundException;
import com.example.cruddesafio02.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria adicionar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria obterPorId(Long id){
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrado com o ID: " + id));
        
    }

    public Categoria atualizar(Long id, Categoria categoria){
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }
}
