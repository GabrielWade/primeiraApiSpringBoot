package com.example.cruddesafio02.model.exception;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }
}
