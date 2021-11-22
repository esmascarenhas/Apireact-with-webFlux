package br.com.esm.apimarvel.controlador;


import br.com.esm.apimarvel.documentos.Heroes;
import br.com.esm.apimarvel.repositorio.HeroesRepository;
import br.com.esm.apimarvel.serviço.HerosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.com.esm.apimarvel.constantes.HerosConstantes.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class HeroesController {
    HerosService heroesService;

    HeroesRepository heroesRepository;

    private static final org.slf4j.Logger getLog= org.slf4j.LoggerFactory.getLogger(HeroesController.class);


    public HeroesController(HerosService heroesService, HeroesRepository heroesRepository) {
        this.heroesService = heroesService;
        this.heroesRepository = heroesRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllItems() {
        log.info("Relação de todos os herois");
        return heroesService.bucarHerois();

    }


    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Localizado o herio com o {id} ", id);
        return heroesService.buscarporHerois(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("Criado um novo Heroi");
        return heroesService.salvarHerois(heroes);

    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
        heroesService.deletar(id);
        log.info("Deletado o Heroi com o id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
