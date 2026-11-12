package com.eliabe.silva.codechella.Application;

import com.eliabe.silva.codechella.adapters.postgres.entities.Evento;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;

import reactor.core.publisher.Mono;

public interface ObterEventoUseCase {
    Mono<EventoDTO> obterEventoPorId(Long id);
}
