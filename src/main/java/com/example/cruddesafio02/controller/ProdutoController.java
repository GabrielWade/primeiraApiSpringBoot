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

import com.example.cruddesafio02.model.ProdutoModel;
import com.example.cruddesafio02.service.ProdutoService;

//Todo controller tem @RestController
//Isso diz ao spring que isso é um controller
@RestController
//isso diz que o controller só irá responder requisições que começam com /api/produtos
    //exemplo: http://localhost:8080/api/produtos
    //a última palavra de ser sempre no plural
    //isso é a famosa rota ou endpoint
@RequestMapping("/api/produtos")
//isso diz que qualquer um pode acessar esse controller
@CrossOrigin("*")
public class ProdutoController {
            
    // quando eu colocar esse @Autowired, o spring vai injetar uma dependencia do ProdutoRepository, ou seja dar a permição ao serviço tirando o repository da caixinha
    @Autowired
    private ProdutoService produtoService;

    //Agora vamos criar os métodos que o controller vai fazer
    //metodo que retorna todos os produtos
    //isso diz que toda requisição get que chegar nesse endpoint, será tratada por esse método
    @GetMapping
    public List<ProdutoModel> obterTodos(){
        //por conta do @Autowired eu não preciso instanciar o produtoService
        return produtoService.obterTodos();

        //resumindoi ess metodo, o controller está chamando o service obterTodos, do serviçõ prudutoService
    }

    @GetMapping("/categoria/{categoriaNome}")
        public List<ProdutoModel> obterPorCategoria(@PathVariable String categoriaNome){
        return produtoService.obterPorCategoria(categoriaNome);
    }

    @GetMapping("/{id}")
    //@PathVariable pega o ID da url e salva em uma propriedade
    public ProdutoModel obterPorId(@PathVariable Long id){

        return produtoService.obterPorId(id);
    }

    //isso diz que toda requisição get que chegar nesse endpoint, será tratada por esse método
    @PostMapping
    // o @RequestBody pega o corpo da requisição e salva em uma propriedade
    public ProdutoModel Adicionar(@RequestBody ProdutoModel produto){
        return produtoService.adicionar(produto);
    }   

    //isso diz que toda requisição put que chegar nesse endpoint, será tratada por esse método
    @PutMapping("/{id}")
    // o @PathVariable pega o ID da url, @RequestBody pega o corpo do objeto e atuliza o produto com esse ID
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produto){
        return produtoService.atualizar(id, produto);
    }  
    
    //isso diz que toda requisição delete que chegar nesse endpoint, será tratada por esse método
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        //@PathVariable pega o ID da url e salva em uma propriedade
        produtoService.deletar(id);
    }
}
