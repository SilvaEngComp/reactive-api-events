package com.eliabe.silva.codechella.Application.port.input.eventos;

import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.domain.enums.TipoEvento;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventosService {

    Flux<EventoDTO> listarEventos();
    Mono<EventoDTO> obterEventoPorId(Long id);
    Mono<EventoDTO> cadastrarEvento(EventoDTO evento);
    Mono<Void> deletarEvento(Long id);
    Flux<EventoDTO> obterEventosPorTipo(String tipo);
    Mono<String> obterTraducao(Long id, String idioma);
}
