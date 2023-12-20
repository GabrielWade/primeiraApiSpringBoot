package com.example.cruddesafio02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddesafio02.model.Categoria;
import com.example.cruddesafio02.model.exception.ResourceNotFoundException;
import com.example.cruddesafio02.repository.CategoriaRepository;

// colocamos esse @ para o spring saber que isso é um serviço
// colocando isso eu não preciso instanciar essa classe em outros lugares
//quando faço isso, eu estou injetando uma dependencia no spring, ou seja adicionar uma quadradinho numa caixa de sapato
@Service
public class CategoriaService {
    //quando o service precisa fazer algo, ele chama o repository, sendo assim, devemos devemos criar um atributo CategoriaRepository
    @Autowired
        // quando eu colocar esse @Autowired, o spring vai injetar uma dependencia do CategoriaRepository, ou seja dar a permição ao serviço tirando o repository da caixinha
    private CategoriaRepository categoriaRepository;
    
    //Agora criamos os metodos que o service vai fazer
    public Categoria adicionar(Categoria categoria){
        //aqui poderia verificar muitas coisas da regra de negocio
        //aqui delegamos a ação add no banco para o repository
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){
        //aqui delegamos a ação obter todos no banco para o repository
        return categoriaRepository.findAll();
    }

    public Categoria obterPorId(Long id){
        //aqui delegamos a ação obter por id no banco para o repository
        //findById retorna um optional
            //optional basicamente é uma caixinha que me retorna o que eu quero ou um null
        return categoriaRepository.findById(id)
            // o metodo orElseThrow() do Optional permite que você lance uma exceção personalizada se o categoria não for encontrado
                //NoSuchElementException é uma exceção em tempo de execução em Java que é lançada quando se tenta acessar um elemento que não existe.
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrado com o ID: " + id));
        
    }

    public Categoria atualizar(Long id, Categoria categoria){

        //o metodo .save atuliza todo id < 1 e atuliza todo id > 0
            //aqui o ideal é verificar se o igredientes existe ou não no banco antes de enviar
            // se não existir, lançar uma exceção de status 404
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id){
        //aqui delegamos a ação deletar no banco para o repository
        //o metodo .deleteById deleta o id que eu passar
        categoriaRepository.deleteById(id);
    }
}
