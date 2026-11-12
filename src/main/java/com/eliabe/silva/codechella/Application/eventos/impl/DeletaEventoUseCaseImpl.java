package com.eliabe.silva.codechella.Application.eventos.impl;

import org.springframework.stereotype.Service;

import com.eliabe.silva.codechella.Application.eventos.DeletaEventoUseCase;
import com.eliabe.silva.codechella.adapters.postgres.EventoRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service 
@AllArgsConstructor 
public class DeletaEventoUseCaseImpl implements DeletaEventoUseCase {
    private final EventoRepository eventoRepository;

    @Override
    public Mono<Void> deletarEvento(Long id) {
        return eventoRepository.findById(id)
        .flatMap(eventoRepository::delete);
    }



}
