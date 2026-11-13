package com.eliabe.silva.codechella.domain.mappers;

import org.mapstruct.Mapper;

import com.eliabe.silva.codechella.domain.dto.IngressoDTO;
import com.eliabe.silva.codechella.infrastructor.adapters.postgres.entities.Ingresso;
@Mapper(componentModel = "spring")
public interface IngressoMapper {
    public static IngressoMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(IngressoMapper.class);
    public Ingresso toEntity(IngressoDTO ingressoDTO);
    public IngressoDTO toDTO(Ingresso ingresso);
}