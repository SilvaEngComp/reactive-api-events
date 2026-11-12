package com.eliabe.silva.codechella.domain.services;

import org.springframework.stereotype.Service;

import com.eliabe.silva.codechella.Application.eventos.CadastraEventoUseCase;
import com.eliabe.silva.codechella.Application.eventos.DeletaEventoUseCase;
import com.eliabe.silva.codechella.Application.eventos.EventosService;
import com.eliabe.silva.codechella.Application.eventos.ListaEventosUseCase;
import com.eliabe.silva.codechella.Application.eventos.ObterEventoUseCase;
import com.eliabe.silva.codechella.adapters.postgres.entities.Evento;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service 
@AllArgsConstructor 
public class EventosServiceImpl implements EventosService {

    private final ListaEventosUseCase listaEventosUseCase;
    private final ObterEventoUseCase obterEventoUseCase;
    private final CadastraEventoUseCase cadastraEventoUseCase;
    private final DeletaEventoUseCase deletaEventoUseCase;

    @Override
    public Flux<EventoDTO> listarEventos() {
        return listaEventosUseCase.listarEventos();
    }

    @Override
    public Mono<EventoDTO> obterEventoPorId(Long id) {
        return obterEventoUseCase.obterEventoPorId(id);
    }

    @Override
    public Mono<EventoDTO> cadastrarEvento(EventoDTO evento) {
        return cadastraEventoUseCase.cadastrarEvento(evento);
    }

    @Override
    public Mono<Void> deletarEvento(Long id) {
      return  deletaEventoUseCase.deletarEvento(id);
    }

}
