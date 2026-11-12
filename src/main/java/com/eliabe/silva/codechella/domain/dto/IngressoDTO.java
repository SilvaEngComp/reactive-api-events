package com.eliabe.silva.codechella.domain.dto;

import java.math.BigDecimal;

import com.eliabe.silva.codechella.domain.enums.TipoIngresso;


public record IngressoDTO(  Long id,
     Long evento_id,
     TipoIngresso tipo,
     BigDecimal valor,
     int total) {

}
