package com.eliabe.silva.codechella.Application.port.input.eventos;

import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.domain.enums.TipoEvento;

import reactor.core.publisher.Flux;

public interface ObterEventoPorTipoUseCase {
Flux<EventoDTO> findbyTipo(String tipo);
}
