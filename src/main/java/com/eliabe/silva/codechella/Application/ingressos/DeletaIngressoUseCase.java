package com.eliabe.silva.codechella.Application.ingressos;

import reactor.core.publisher.Mono;

public interface DeletaIngressoUseCase {

    Mono<Void> deletarIngresso(Long id);

}
