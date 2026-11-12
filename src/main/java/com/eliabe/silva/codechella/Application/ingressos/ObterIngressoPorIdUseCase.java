package com.eliabe.silva.codechella.Application.ingressos;

import com.eliabe.silva.codechella.domain.dto.IngressoDTO;

import reactor.core.publisher.Mono;

public interface ObterIngressoPorIdUseCase {

    Mono<IngressoDTO> obterIngressoPorId(Long id);

}
