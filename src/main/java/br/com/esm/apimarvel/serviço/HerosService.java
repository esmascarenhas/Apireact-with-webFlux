package br.com.esm.apimarvel.serviço;

import br.com.esm.apimarvel.documentos.Heroes;
import br.com.esm.apimarvel.repositorio.HeroesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class HerosService {

    private HeroesRepository heroesRepository;


    public Flux<Heroes> bucarHerois (){
        return Flux.fromIterable(this.heroesRepository.findAll());
    }
    public Mono<Heroes> buscarporHerois(String id){
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }
    public Mono<Heroes> salvarHerois (Heroes heros){
        return Mono.justOrEmpty(this.heroesRepository.save(heros));
    }
    public Mono <Boolean> deletar (String id){
        heroesRepository.deleteById(id);
        return Mono.just(true);
    }
}
