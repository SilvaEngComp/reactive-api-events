package com.eliabe.silva.codechella.Application.ingressos.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.eliabe.silva.codechella.Application.ingressos.AlteraIngressoUseCase;
import com.eliabe.silva.codechella.adapters.postgres.IngressoRepository;
import com.eliabe.silva.codechella.domain.dto.IngressoDTO;
import com.eliabe.silva.codechella.domain.mappers.IngressoMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component 
@AllArgsConstructor
public class AlteraIngressoUseCaseImpl implements AlteraIngressoUseCase {
    private final IngressoRepository ingressoRepository;

    @Override
    public Mono<IngressoDTO> alterarIngresso(Long id, IngressoDTO dto) {
        return ingressoRepository.findById(id)
        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
        .flatMap(ingresso -> {
            ingresso.setEvento_id(id);
            ingresso.setTipo(dto.tipo());
            ingresso.setValor(dto.valor());
            ingresso.setTotal(dto.total());
            return ingressoRepository.save(ingresso);
        })
        .map(IngressoMapper.INSTANCE::toDTO);
    }

}
