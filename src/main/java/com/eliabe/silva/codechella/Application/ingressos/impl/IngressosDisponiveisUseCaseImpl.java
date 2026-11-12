package com.eliabe.silva.codechella.Application.ingressos.impl;

import org.springframework.stereotype.Component;

import com.eliabe.silva.codechella.Application.ingressos.IngressosDisponiveisUseCase;
import com.eliabe.silva.codechella.adapters.postgres.IngressoRepository;
import com.eliabe.silva.codechella.domain.dto.IngressoDTO;
import com.eliabe.silva.codechella.domain.mappers.IngressoMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Component 
@AllArgsConstructor 
public class IngressosDisponiveisUseCaseImpl implements IngressosDisponiveisUseCase {
private final IngressoRepository ingressoRepository;

@Override
public Flux<IngressoDTO> listarIngressosDisponiveis() {
   return ingressoRepository.findAll().map(ingresso -> IngressoMapper.INSTANCE.toDTO(ingresso));
}

}
