package com.eliabe.silva.codechella.infrastructor.adapters.clientes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.eliabe.silva.codechella.Application.port.input.traducao.DeepLApiClient;
import com.eliabe.silva.codechella.domain.models.Traducao;

import reactor.core.publisher.Mono;

@Component 
public class DeepLApiTranslationClient implements DeepLApiClient {

    @Value("${deepL.token}")
    private  String apiKey;

    @Value("${deepL.host}")
    private  String apiUrl;

     @Value("${deepL.endpoint}")
    private  String endpoint;

    

    @Override
    public Mono<String> traduzirTexto(String texto, String idioma) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();

        requestBody.add("text", texto);
        requestBody.add("target_lang", idioma);
        WebClient client = WebClient.builder().baseUrl(apiUrl+endpoint).build();

        return client.post()
                .header("Authorization", apiKey)
                .body(BodyInserters.fromFormData(requestBody))
                .retrieve()
                .bodyToMono(Traducao.class)
                .map(Traducao::getTexto);
    }

}
