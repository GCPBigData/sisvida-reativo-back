package br.sisvida.repository;

import com.googolplex.documents.Pessoa;
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
}
