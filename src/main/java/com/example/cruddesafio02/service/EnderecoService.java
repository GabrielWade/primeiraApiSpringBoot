package com.example.cruddesafio02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddesafio02.model.Endereco;
import com.example.cruddesafio02.model.exception.ResourceNotFoundException;
import com.example.cruddesafio02.repository.EnderecoRepository;

// colocamos esse @ para o spring saber que isso é um serviço
// colocando isso eu não preciso instanciar essa classe em outros lugares
//quando faço isso, eu estou injetando uma dependencia no spring, ou seja adicionar uma quadradinho numa caixa de sapato
@Service
public class EnderecoService {
    //quando o service precisa fazer algo, ele chama o repository, sendo assim, devemos devemos criar um atributo EnderecoRepository
    @Autowired
        // quando eu colocar esse @Autowired, o spring vai injetar uma dependencia do EnderecoRepository, ou seja dar a permição ao serviço tirando o repository da caixinha
    private EnderecoRepository enderecoRepository;
    
    //Agora criamos os metodos que o service vai fazer
    public Endereco adicionar(Endereco endereco){
        //aqui poderia verificar muitas coisas da regra de negocio
        //aqui delegamos a ação add no banco para o repository
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obterTodos(){
        //aqui delegamos a ação obter todos no banco para o repository
        return enderecoRepository.findAll();
    }

    public Endereco obterPorId(Long id){
        //aqui delegamos a ação obter por id no banco para o repository
        //findById retorna um optional
            //optional basicamente é uma caixinha que me retorna o que eu quero ou um null
        return enderecoRepository.findById(id)
            // o metodo orElseThrow() do Optional permite que você lance uma exceção personalizada se o endereco não for encontrado
                //NoSuchElementException é uma exceção em tempo de execução em Java que é lançada quando se tenta acessar um elemento que não existe.
            .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado com o ID: " + id));
        
    }

    public Endereco atualizar(Long id, Endereco endereco){

        //o metodo .save atuliza todo id < 1 e atuliza todo id > 0
            //aqui o ideal é verificar se o igredientes existe ou não no banco antes de enviar
            // se não existir, lançar uma exceção de status 404
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id){
        //aqui delegamos a ação deletar no banco para o repository
        //o metodo .deleteById deleta o id que eu passar
        enderecoRepository.deleteById(id);
    }
}
