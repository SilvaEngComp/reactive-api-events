package com.eliabe.silva.codechella.Application.port.input.eventos.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.eliabe.silva.codechella.Application.port.input.eventos.ObterEventoUseCase;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.domain.mappers.EventoMapper;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.EventoRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service 
@AllArgsConstructor 
public class ObterEventoUseCaseImpl implements ObterEventoUseCase {
    private final EventoRepository eventoRepository;

    @Override
    public Mono<EventoDTO> obterEventoPorId(Long id) {
       return eventoRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))).map(EventoMapper::toDTO);
    }

    

}
