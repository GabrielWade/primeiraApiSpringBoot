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

import com.example.cruddesafio02.model.Cliente;
import com.example.cruddesafio02.service.ClienteService;

//Todo controller tem @RestController
//Isso diz ao spring que isso é um controller
@RestController
//isso diz que o controller só irá responder requisições que começam com /api/clientes
    //exemplo: http://localhost:8080/api/clientes
    //a última palavra de ser sempre no plural
    //isso é a famosa rota ou endpoint
@RequestMapping("/api/clientes")
//isso diz que qualquer um pode acessar esse controller
@CrossOrigin("*")
public class ClienteController {
            
    // quando eu colocar esse @Autowired, o spring vai injetar uma dependencia do ClienteRepository, ou seja dar a permição ao serviço tirando o repository da caixinha
    @Autowired
    private ClienteService clienteService;

    //Agora vamos criar os métodos que o controller vai fazer
    //metodo que retorna todos os clientes
    //isso diz que toda requisição get que chegar nesse endpoint, será tratada por esse método
    @GetMapping
    public List<Cliente> obterTodos(){
        //por conta do @Autowired eu não preciso instanciar o clienteService
        return clienteService.obterTodos();

        //resumindoi ess metodo, o controller está chamando o service obterTodos, do serviçõ prudutoService
    }

    @GetMapping("/{id}")
    //@PathVariable pega o ID da url e salva em uma propriedade
    public Cliente obterPorId(@PathVariable Long id){

        return clienteService.obterPorId(id);
    }

    //isso diz que toda requisição get que chegar nesse endpoint, será tratada por esse método
    @PostMapping
    // o @RequestBody pega o corpo da requisição e salva em uma propriedade
    public Cliente Adicionar(@RequestBody Cliente cliente){
        return clienteService.adicionar(cliente);
    }   

    //isso diz que toda requisição put que chegar nesse endpoint, será tratada por esse método
    @PutMapping("/{id}")
    // o @PathVariable pega o ID da url, @RequestBody pega o corpo do objeto e atuliza o cliente com esse ID
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.atualizar(id, cliente);
    }  
    
    //isso diz que toda requisição delete que chegar nesse endpoint, será tratada por esse método
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        //@PathVariable pega o ID da url e salva em uma propriedade
        clienteService.deletar(id);
    }
}
