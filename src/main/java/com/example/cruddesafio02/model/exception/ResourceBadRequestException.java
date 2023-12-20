package com.example.cruddesafio02.model.exception;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException(String mensagem) {
        super(mensagem);
    }
}
