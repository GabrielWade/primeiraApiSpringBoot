package com.example.cruddesafio02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddesafio02.model.ProdutoModel;
import com.example.cruddesafio02.model.exception.ResourceNotFoundException;
import com.example.cruddesafio02.repository.ProdutoRepository;

// colocamos esse @ para o spring saber que isso é um serviço
// colocando isso eu não preciso instanciar essa classe em outros lugares
//quando faço isso, eu estou injetando uma dependencia no spring, ou seja adicionar uma quadradinho numa caixa de sapato
@Service
public class ProdutoService {
    //quando o service precisa fazer algo, ele chama o repository, sendo assim, devemos devemos criar um atributo ProdutoRepository
    @Autowired
        // quando eu colocar esse @Autowired, o spring vai injetar uma dependencia do ProdutoRepository, ou seja dar a permição ao serviço tirando o repository da caixinha
    private ProdutoRepository produtoRepository;
    
    //Agora criamos os metodos que o service vai fazer
    public ProdutoModel adicionar(ProdutoModel produto){
        //aqui poderia verificar muitas coisas da regra de negocio
        //aqui delegamos a ação add no banco para o repository
        return produtoRepository.save(produto);
    }

    public List<ProdutoModel> obterTodos(){
        //aqui delegamos a ação obter todos no banco para o repository
        return produtoRepository.findAll();
    }

    public List<ProdutoModel> obterPorCategoria(String nome){
        return produtoRepository.findByCategoria_Nome(nome);
    }

    public ProdutoModel obterPorId(Long id){
        //aqui delegamos a ação obter por id no banco para o repository
        //findById retorna um optional
            //optional basicamente é uma caixinha que me retorna o que eu quero ou um null
        return produtoRepository.findById(id)
            // o metodo orElseThrow() do Optional permite que você lance uma exceção personalizada se o produto não for encontrado
                //NoSuchElementException é uma exceção em tempo de execução em Java que é lançada quando se tenta acessar um elemento que não existe.
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));
        
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produto){

        //o metodo .save atuliza todo id < 1 e atuliza todo id > 0
            //aqui o ideal é verificar se o igredientes existe ou não no banco antes de enviar
            // se não existir, lançar uma exceção de status 404
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
        //aqui delegamos a ação deletar no banco para o repository
        //o metodo .deleteById deleta o id que eu passar
        produtoRepository.deleteById(id);
    }
}
