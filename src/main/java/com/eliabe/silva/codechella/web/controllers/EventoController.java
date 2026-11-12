package com.eliabe.silva.codechella.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliabe.silva.codechella.Application.EventosService;
import com.eliabe.silva.codechella.adapters.postgres.entities.Evento;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/eventos")
public class EventoController {
    private final EventosService eventosService;

    public EventoController(EventosService eventosService){
        this.eventosService = eventosService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDTO> listarEventos(){
        return eventosService.listarEventos();
    }

    @GetMapping("/{id}")
    public Mono<EventoDTO> obterEventoPorId(@PathVariable Long id){
        return eventosService.obterEventoPorId(id);
    }

    
    @PostMapping
    public Mono<EventoDTO> cadastrarEventos(@RequestBody EventoDTO eventoDTO){
        return eventosService.cadastrarEvento(eventoDTO);
    }

    
    @DeleteMapping ("/{id}")
    public Mono<Void> deletarEvento(@PathVariable Long id){
        return eventosService.deletarEvento(id);
    }

}
