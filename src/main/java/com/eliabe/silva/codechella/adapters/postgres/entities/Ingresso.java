package com.eliabe.silva.codechella.adapters.postgres.entities;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.eliabe.silva.codechella.domain.enums.TipoIngresso;

@Table ("ingressos")
public class Ingresso {
    @Id 
    private Long id;
    private Long evento_id;
    private TipoIngresso tipo;
    private BigDecimal valor;
    private int total;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getEvento_id() {
        return evento_id;
    }
    public void setEvento_id(Long evento_id) {
        this.evento_id = evento_id;
    }
    public TipoIngresso getTipo() {
        return tipo;
    }
    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    // Getters and setters
}
