package com.eliabe.silva.codechella.domain.services.useCases;

import org.springframework.stereotype.Service;

import com.eliabe.silva.codechella.Application.ListaEventosUseCase;
import com.eliabe.silva.codechella.adapters.postgres.EventoRepository;
import com.eliabe.silva.codechella.adapters.postgres.entities.Evento;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.domain.mappers.EventoMapper;

import reactor.core.publisher.Flux;

@Service 
public class ListaEventosUseCaseImpl implements ListaEventosUseCase {

    private final EventoRepository eventoRepository;

    public ListaEventosUseCaseImpl(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Flux<EventoDTO> listarEventos() {
        return eventoRepository.findAll().map(EventoMapper::toDTO);
    }
}
