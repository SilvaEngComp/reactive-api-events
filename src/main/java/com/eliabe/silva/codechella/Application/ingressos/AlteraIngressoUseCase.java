package com.eliabe.silva.codechella.Application.ingressos;

import com.eliabe.silva.codechella.domain.dto.IngressoDTO;

import reactor.core.publisher.Mono;

public interface AlteraIngressoUseCase {

    Mono<IngressoDTO> alterarIngresso(Long id, IngressoDTO ingresso);

}
