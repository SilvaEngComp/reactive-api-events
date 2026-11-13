package com.eliabe.silva.codechella.infrastructor.adapters.postgres;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.eliabe.silva.codechella.infrastructor.adapters.postgres.entities.Ingresso;

public interface IngressoRepository extends ReactiveCrudRepository<Ingresso, Long>{

}
