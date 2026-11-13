package com.eliabe.silva.codechella.Application.port.input.ingressos.impl;

import org.springframework.stereotype.Component;

import com.eliabe.silva.codechella.Application.port.input.ingressos.IngressosDisponiveisUseCase;
import com.eliabe.silva.codechella.domain.dto.IngressoDTO;
import com.eliabe.silva.codechella.domain.mappers.IngressoMapper;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.IngressoRepository;

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
