package com.eliabe.silva.codechella.Application.port.input.eventos;

import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.entities.Evento;

import reactor.core.publisher.Mono;

public interface CadastraEventoUseCase {

    Mono<EventoDTO> cadastrarEvento(EventoDTO evento);
}
