package com.eliabe.silva.codechella.Application.port.input.eventos;

import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.entities.Evento;

import reactor.core.publisher.Mono;

public interface ObterEventoUseCase {
    Mono<EventoDTO> obterEventoPorId(Long id);
}
