package com.example.cruddesafio02.model;



import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private long id;

    //Estou dizendo que a categoria tem muitos produtos
        //(mappedBy = "categoria") está dizendo que a entidade ProdutoModel é a proprietária do relacionamento. Isso significa que qualquer alteração no relacionamento deve ser feita do lado ProdutoModel.
        //Em outras palavra, aqui estou dizendo para tabela ProdutodoModel vai conhecer lá no banco 
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private String cep;

    private String rua;

    private String bairro;

    private String cidade;

    @Column(nullable = false)
    private String estado;

    private String complemento;

    private Integer numero;

    //#region Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    //#endregion
}
