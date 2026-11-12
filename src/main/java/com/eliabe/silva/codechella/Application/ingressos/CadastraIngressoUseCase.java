package com.eliabe.silva.codechella.Application.ingressos;

import com.eliabe.silva.codechella.domain.dto.IngressoDTO;

import reactor.core.publisher.Mono;

public interface CadastraIngressoUseCase {

    Mono<IngressoDTO> cadastrarIngresso(IngressoDTO ingresso);
}
