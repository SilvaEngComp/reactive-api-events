package com.eliabe.silva.codechella.Application.ingressos.impl;

import org.springframework.stereotype.Component;

import com.eliabe.silva.codechella.Application.ingressos.DeletaIngressoUseCase;
import com.eliabe.silva.codechella.adapters.postgres.IngressoRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component 
@AllArgsConstructor 
public class DeletaIngressoUseCaseImpl implements DeletaIngressoUseCase {
private final IngressoRepository ingressoRepository;

@Override
public Mono<Void> deletarIngresso(Long id) {
    return ingressoRepository.findById(id)
    .flatMap(ingressoRepository::delete);
}

}
