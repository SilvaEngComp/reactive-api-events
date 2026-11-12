package com.eliabe.silva.codechella.Application.ingressos.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.eliabe.silva.codechella.Application.ingressos.ObterIngressoPorIdUseCase;
import com.eliabe.silva.codechella.adapters.postgres.IngressoRepository;
import com.eliabe.silva.codechella.domain.dto.IngressoDTO;
import com.eliabe.silva.codechella.domain.mappers.IngressoMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ObterIngressoPorIdUseCaseImpl implements ObterIngressoPorIdUseCase {
    private final IngressoRepository ingressoRepository;

    @Override
    public Mono<IngressoDTO> obterIngressoPorId(Long id) {
        return ingressoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(IngressoMapper.INSTANCE::toDTO);
    }

}
