package com.eliabe.silva.codechella.Application.eventos;

import reactor.core.publisher.Mono;

public interface DeletaEventoUseCase {
Mono<Void> deletarEvento(Long id);
}
