package com.eliabe.silva.codechella.domain.dto;

import java.time.LocalDate;

import com.eliabe.silva.codechella.domain.enums.TipoEvento;

public record EventoDTO(Long id,TipoEvento tipoEvento, String nome, String descricao, LocalDate data) {

}
