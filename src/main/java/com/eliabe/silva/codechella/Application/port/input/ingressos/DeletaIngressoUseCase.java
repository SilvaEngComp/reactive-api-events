package com.eliabe.silva.codechella.Application.port.input.ingressos;

import reactor.core.publisher.Mono;

public interface DeletaIngressoUseCase {

    Mono<Void> deletarIngresso(Long id);

}
