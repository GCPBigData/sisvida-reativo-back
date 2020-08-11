package br.sisvida.repository;

import com.googolplex.documents.Pessoa;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */

public interface PessoaRepository extends ReactiveMongoRepository<Pessoa, String>{
    Mono<Pessoa> findByCpf(String cpf);
    Flux<Pessoa> findByNome(String nome);
    Flux<Pessoa> findByMatricula(String matricula);
    Flux<Pessoa> findByEmail(String email);

    //db.getCollection('pessoa').find({ 'nome': { $regex: "maria", $options: 'i' } })
    @Query("{'nome':{$regex:?0,$options:'i'}}")
    Flux<Pessoa> searchNome(String nome);

    //db.getCollection('pessoa').find({$or:[{'nome':{$regex:?0,$options:'i'}},{'cpf':{$regex:?0,$options:'i'}}]})
    @Query("{$or:[{'nome':{$regex:?0,$options:'i'}},{'cpf':{$regex:?0,$options:'i'}}]}")
    Flux<Pessoa> fullSearch(String nome, String cpf);
}
