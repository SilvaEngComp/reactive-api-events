package com.eliabe.silva.codechella.Application.port.input.eventos;

import com.eliabe.silva.codechella.domain.dto.EventoDTO;

import reactor.core.publisher.Flux;

public interface ListaEventosUseCase {

    Flux<EventoDTO> listarEventos();
}
