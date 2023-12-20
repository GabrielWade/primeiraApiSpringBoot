package com.example.cruddesafio02.model;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cetegoria")
    private long id;

    //Estou dizendo que a categoria tem muitos produtos
        //(mappedBy = "categoria") está dizendo que a entidade ProdutoModel é a proprietária do relacionamento. Isso significa que qualquer alteração no relacionamento deve ser feita do lado ProdutoModel.
        //Em outras palavra, aqui estou dizendo para tabela ProdutodoModel vai conhecer lá no banco 
    @OneToMany(mappedBy = "categoria")
    private List<ProdutoModel> produtos;

    //#region Getters and Setters

    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   

    //#endregion
}
