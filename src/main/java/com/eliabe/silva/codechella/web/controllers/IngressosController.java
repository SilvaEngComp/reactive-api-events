package com.eliabe.silva.codechella.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliabe.silva.codechella.Application.ingressos.IngressoService;
import com.eliabe.silva.codechella.domain.dto.IngressoDTO;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/ingressos")
@AllArgsConstructor
public class IngressosController {

    private final IngressoService ingressosService;

    @GetMapping
    public Flux<IngressoDTO> listarIngressosDisponiveis() {
        return ingressosService.listarIngressosDisponiveis();
    }

    @GetMapping("/{id}")
    public Mono<IngressoDTO> obterIngressoPorId(@PathVariable Long id) {
        return ingressosService.obterIngressoPorId(id);
    }

    @PutMapping("/{id}")
    public Mono<IngressoDTO> alterarIngresso(@PathVariable Long id, @RequestBody IngressoDTO ingresso) {
        return ingressosService.alterarIngresso(id, ingresso);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletarIngresso(@PathVariable Long id) {
        return ingressosService.deletarIngresso(id);
    }

    @PostMapping
    public Mono<IngressoDTO> cadastrarIngresso(@RequestBody IngressoDTO ingresso) {
        return ingressosService.cadastrarIngresso(ingresso);
    }

}
