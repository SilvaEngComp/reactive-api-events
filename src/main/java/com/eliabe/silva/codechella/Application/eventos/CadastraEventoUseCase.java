package com.eliabe.silva.codechella.Application.eventos;

import com.eliabe.silva.codechella.adapters.postgres.entities.Evento;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;

import reactor.core.publisher.Mono;

public interface CadastraEventoUseCase {

    Mono<EventoDTO> cadastrarEvento(EventoDTO evento);
}
