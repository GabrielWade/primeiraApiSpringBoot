package com.example.cruddesafio02.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.cruddesafio02.model.ModeloErro;
import com.example.cruddesafio02.model.exception.ResourceBadRequestException;
import com.example.cruddesafio02.model.exception.ResourceNotFoundException;

//Essa anotação diz para o spring que essa classe é um handler, onde irá cuidar de todas as exceções
@ControllerAdvice
public class RestExceptionHandler {
    
    //toda vez que um ResourceNotFoundException for lançado, esse método será chamado
    @ExceptionHandler(ResourceNotFoundException.class)
        //ResponseEntity é uma classe do spring que representa uma resposta http
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex){
        
        //toda exceção tem uma mensagem e um status
        ModeloErro erro = new ModeloErro("Not Found", ex.getMessage(), 404);
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
        //ResponseEntity é uma classe do spring que representa uma resposta http
    public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException ex){
        
        //toda exceção tem uma mensagem e um status
            //HttpStatus.BAD_REQUEST.value() é um eneum que retorna o núero do status do erro
        ModeloErro erro = new ModeloErro("Bed Request", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(404).body(erro);
    }

    //Essa é uma exceção como todas as outras porém é um exceção que cobre os erros genéricos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerResourceException(Exception ex){

        ModeloErro erro = new ModeloErro("Internal Server Error", ex.getMessage(), 500);
        return ResponseEntity.status(500).body(erro);
    }
    
}
