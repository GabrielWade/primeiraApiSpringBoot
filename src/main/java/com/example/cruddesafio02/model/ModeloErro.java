package com.example.cruddesafio02.model;

public class ModeloErro {

    private String titulo;
    private String mensagem;
    private int status;

    public ModeloErro(String titulo, String mensagem, int status) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.status = status;
    }

    //#region getters e setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    //#endregion
    
}
