package com.eliabe.silva.codechella.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliabe.silva.codechella.Application.port.input.eventos.EventosService;
import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController 
@RequestMapping ("/eventos")
public class EventoController {
    private final EventosService eventosService;
    private final Sinks.Many<EventoDTO> eventoSink;

    public EventoController(EventosService eventosService){
        this.eventosService = eventosService;
        this.eventoSink = Sinks.many().multicast().onBackpressureBuffer();
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
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EventoDTO> cadastrarEventos(@RequestBody EventoDTO eventoDTO){
        return eventosService.cadastrarEvento(eventoDTO).doOnSuccess(evento -> eventoSink.tryEmitNext(evento));
    }

    
    @DeleteMapping ("/{id}")
    public Mono<Void> deletarEvento(@PathVariable Long id){
        return eventosService.deletarEvento(id);
    }

    @GetMapping(value = "/categoria/{tipo}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDTO> obterEventosPorTipo(@PathVariable String tipo) {
        return Flux.merge(eventosService.obterEventosPorTipo(tipo), eventoSink.asFlux())
        .delayElements(Duration.ofSeconds(4));
    }

     @GetMapping("/{id}/traduzir/{idioma}")
    public Mono<String> obterTraducao(@PathVariable Long id, @PathVariable String idioma){
        return eventosService.obterTraducao(id, idioma);
    }
    

}
