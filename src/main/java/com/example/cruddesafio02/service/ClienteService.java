package com.example.cruddesafio02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddesafio02.model.Cliente;
import com.example.cruddesafio02.model.exception.ResourceNotFoundException;
import com.example.cruddesafio02.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente adicionar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodos(){
        return clienteRepository.findAll();
    }

    public Cliente obterPorId(Long id){
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    public Cliente atualizar(Long id, Cliente cliente){
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }
}
