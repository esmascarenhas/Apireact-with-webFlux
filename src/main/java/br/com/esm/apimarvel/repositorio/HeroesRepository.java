package br.com.esm.apimarvel.repositorio;

import br.com.esm.apimarvel.documentos.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes,String> {
}
