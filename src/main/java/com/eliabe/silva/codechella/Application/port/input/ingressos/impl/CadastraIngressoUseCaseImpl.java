package com.eliabe.silva.codechella.Application.port.input.ingressos.impl;

import org.springframework.stereotype.Component;

import com.eliabe.silva.codechella.Application.port.input.ingressos.CadastraIngressoUseCase;
import com.eliabe.silva.codechella.domain.dto.IngressoDTO;
import com.eliabe.silva.codechella.domain.mappers.IngressoMapper;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.IngressoRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component 
@AllArgsConstructor 
public class CadastraIngressoUseCaseImpl implements CadastraIngressoUseCase {
private final IngressoRepository ingressoRepository;

@Override
public Mono<IngressoDTO> cadastrarIngresso(IngressoDTO ingresso) {
   return ingressoRepository.save(IngressoMapper.INSTANCE.toEntity(ingresso)).map(IngressoMapper.INSTANCE::toDTO);
}
}
