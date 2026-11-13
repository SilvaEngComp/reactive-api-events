package com.eliabe.silva.codechella.Application.port.input.eventos;

import reactor.core.publisher.Mono;

public interface TraducaoUseCase {

    Mono<String> traduzirTexto(Long id, String idioma);

}
