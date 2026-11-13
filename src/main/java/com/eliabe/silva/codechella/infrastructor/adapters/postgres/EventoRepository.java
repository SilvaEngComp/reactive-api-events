package com.eliabe.silva.codechella.infrastructor.adapters.postgres;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.eliabe.silva.codechella.domain.enums.TipoEvento;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.entities.Evento;

import reactor.core.publisher.Flux;

public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {

    Flux<Evento> findByTipo(TipoEvento tipo);

}
