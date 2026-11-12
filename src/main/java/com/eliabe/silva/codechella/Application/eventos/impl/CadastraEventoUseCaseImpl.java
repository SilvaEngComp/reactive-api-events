package com.eliabe.silva.codechella.Application.eventos.impl;

import org.springframework.stereotype.Service;

import com.eliabe.silva.codechella.Application.eventos.CadastraEventoUseCase;
import com.eliabe.silva.codechella.adapters.postgres.EventoRepository;
import com.eliabe.silva.codechella.adapters.postgres.entities.Evento;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.domain.mappers.EventoMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service 
@AllArgsConstructor 
public class CadastraEventoUseCaseImpl implements CadastraEventoUseCase {

    private final EventoRepository eventoRepository;
 
    @Override
    public Mono<EventoDTO> cadastrarEvento(EventoDTO evento) {
        Evento entity = EventoMapper.toEntity(evento);
        return eventoRepository.save(entity).map(EventoMapper::toDTO);
    }

}
