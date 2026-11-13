package com.eliabe.silva.codechella.Application.port.input.traducao;

import reactor.core.publisher.Mono;

public interface DeepLApiClient {
Mono<String> traduzirTexto(String texto, String idioma);
}
