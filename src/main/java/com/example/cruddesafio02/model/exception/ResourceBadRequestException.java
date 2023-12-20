package com.example.cruddesafio02.model.exception;

//Essa classe é uma exceção, onde será lançada quando o usuário enviar um dado inválido
//toda exceção deve erdar de um exceção, portanto essa classe herda de RuntimeException
public class ResourceBadRequestException extends RuntimeException {
    //basta eu colocar ResourceBadRequestException toda vez que eu tiver um exceção
    public ResourceBadRequestException(String mensagem) {
        super(mensagem);
    }
}
