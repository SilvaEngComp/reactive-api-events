package com.eliabe.silva.codechella.Application.port.input.eventos.impl;

import org.springframework.stereotype.Component;

import com.eliabe.silva.codechella.Application.port.input.eventos.ObterEventoPorTipoUseCase;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.domain.enums.TipoEvento;
import com.eliabe.silva.codechella.domain.mappers.EventoMapper;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.EventoRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Component 
@AllArgsConstructor 
public class ObterEventoPorTipoUseCaseImpl implements ObterEventoPorTipoUseCase{
    private final EventoRepository eventoRepository;

    @Override
    public Flux<EventoDTO> findbyTipo(String tipo) {
        var tipoEvento = TipoEvento.valueOf(tipo.toUpperCase());
       return eventoRepository.findByTipo(tipoEvento).map(EventoMapper::toDTO);
    }

}
