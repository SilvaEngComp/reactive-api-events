package com.eliabe.silva.codechella.domain.services.useCases;

import org.springframework.stereotype.Service;

import com.eliabe.silva.codechella.Application.DeletaEventoUseCase;
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
