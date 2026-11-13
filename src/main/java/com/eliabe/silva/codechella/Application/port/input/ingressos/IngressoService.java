package com.eliabe.silva.codechella.Application.port.input.ingressos;

import com.eliabe.silva.codechella.domain.dto.IngressoDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngressoService {
    Flux<IngressoDTO> listarIngressosDisponiveis();

    Mono<IngressoDTO> obterIngressoPorId(Long id);

    Mono<IngressoDTO> alterarIngresso(Long id, IngressoDTO ingresso);

    Mono<Void> deletarIngresso(Long id);

    Mono<IngressoDTO> cadastrarIngresso(IngressoDTO ingresso);
}
