package com.example.cruddesafio02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddesafio02.model.Categoria;
import com.example.cruddesafio02.service.CategoriaService;

//Todo controller tem @RestController
//Isso diz ao spring que isso é um controller
@RestController
//isso diz que o controller só irá responder requisições que começam com /api/categorias
    //exemplo: http://localhost:8080/api/categorias
    //a última palavra de ser sempre no plural
    //isso é a famosa rota ou endpoint
@RequestMapping("/api/categorias")
//isso diz que qualquer um pode acessar esse controller
@CrossOrigin("*")
public class CategoriaController {
            
    // quando eu colocar esse @Autowired, o spring vai injetar uma dependencia do CategoriaRepository, ou seja dar a permição ao serviço tirando o repository da caixinha
    @Autowired
    private CategoriaService categoriaService;

    //Agora vamos criar os métodos que o controller vai fazer
    //metodo que retorna todos os categorias
    //isso diz que toda requisição get que chegar nesse endpoint, será tratada por esse método
    @GetMapping
    public List<Categoria> obterTodos(){
        //por conta do @Autowired eu não preciso instanciar o categoriaService
        return categoriaService.obterTodos();

        //resumindoi ess metodo, o controller está chamando o service obterTodos, do serviçõ prudutoService
    }

    @GetMapping("/{id}")
    //@PathVariable pega o ID da url e salva em uma propriedade
    public Categoria obterPorId(@PathVariable Long id){

        return categoriaService.obterPorId(id);
    }

    //isso diz que toda requisição get que chegar nesse endpoint, será tratada por esse método
    @PostMapping
    // o @RequestBody pega o corpo da requisição e salva em uma propriedade
    public Categoria Adicionar(@RequestBody Categoria categoria){
        return categoriaService.adicionar(categoria);
    }   

    //isso diz que toda requisição put que chegar nesse endpoint, será tratada por esse método
    @PutMapping("/{id}")
    // o @PathVariable pega o ID da url, @RequestBody pega o corpo do objeto e atuliza o categoria com esse ID
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.atualizar(id, categoria);
    }  
    
    //isso diz que toda requisição delete que chegar nesse endpoint, será tratada por esse método
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        //@PathVariable pega o ID da url e salva em uma propriedade
        categoriaService.deletar(id);
    }
}