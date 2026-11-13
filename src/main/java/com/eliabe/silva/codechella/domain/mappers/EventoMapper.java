package com.eliabe.silva.codechella.domain.mappers;

import com.eliabe.silva.codechella.domain.dto.EventoDTO;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.entities.Evento;

public class EventoMapper {

    public static Evento toEntity(EventoDTO evento) {
        if (evento == null) {
            return null;
        }
        Evento entity = new Evento();
        entity.setNome(evento.nome());
        entity.setDescricao(evento.descricao());
        entity.setData(evento.data());
        entity.setTipo(evento.tipoEvento());
        return entity;
    }

    public static EventoDTO toDTO(Evento evento) {
        if (evento == null) {
            return null;
        }
        return new EventoDTO(evento.getId(),evento.getTipo(), evento.getNome(), evento.getDescricao(), evento.getData());
    }
}
