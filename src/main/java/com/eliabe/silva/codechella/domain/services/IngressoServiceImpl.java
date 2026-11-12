package com.eliabe.silva.codechella.domain.services;

import org.springframework.stereotype.Service;

import com.eliabe.silva.codechella.Application.ingressos.AlteraIngressoUseCase;
import com.eliabe.silva.codechella.Application.ingressos.CadastraIngressoUseCase;
import com.eliabe.silva.codechella.Application.ingressos.DeletaIngressoUseCase;
import com.eliabe.silva.codechella.Application.ingressos.IngressoService;
import com.eliabe.silva.codechella.Application.ingressos.IngressosDisponiveisUseCase;
import com.eliabe.silva.codechella.Application.ingressos.ObterIngressoPorIdUseCase;
import com.eliabe.silva.codechella.domain.dto.IngressoDTO;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class IngressoServiceImpl implements IngressoService {

    private final IngressosDisponiveisUseCase ingressosDisponiveisUseCase;
    private final ObterIngressoPorIdUseCase obterIngressoPorIdUseCase;
    private final DeletaIngressoUseCase deletaIngressoUseCase;
    private final CadastraIngressoUseCase cadastraIngressoUseCase;
    private final AlteraIngressoUseCase alteraIngressoUseCase;

    @Override
    public Flux<IngressoDTO> listarIngressosDisponiveis() {
       return ingressosDisponiveisUseCase.listarIngressosDisponiveis();
    }

    @Override
    public Mono<IngressoDTO> obterIngressoPorId(Long id) {
        return obterIngressoPorIdUseCase.obterIngressoPorId(id);
    }

    @Override
    public Mono<IngressoDTO> alterarIngresso(Long id, IngressoDTO ingresso) {
        return alteraIngressoUseCase.alterarIngresso(id, ingresso);
    }

    @Override
    public Mono<Void> deletarIngresso(Long id) {
        return deletaIngressoUseCase.deletarIngresso(id);
    }

    @Override
    public Mono<IngressoDTO> cadastrarIngresso(IngressoDTO ingresso) {
       return cadastraIngressoUseCase.cadastrarIngresso(ingresso);
    }

}
