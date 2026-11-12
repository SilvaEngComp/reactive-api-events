package com.eliabe.silva.codechella.adapters.postgres;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.eliabe.silva.codechella.adapters.postgres.entities.Evento;

@Repository 
public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {

}
