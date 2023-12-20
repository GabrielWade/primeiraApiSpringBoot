package com.example.cruddesafio02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddesafio02.model.Endereco;
import com.example.cruddesafio02.model.exception.ResourceNotFoundException;
import com.example.cruddesafio02.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    public Endereco adicionar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obterTodos(){
        return enderecoRepository.findAll();
    }

    public Endereco obterPorId(Long id){
        return enderecoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado com o ID: " + id));
    }

    public Endereco atualizar(Long id, Endereco endereco){
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id){
        enderecoRepository.deleteById(id);
    }
}
