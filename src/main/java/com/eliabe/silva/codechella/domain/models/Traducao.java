package com.eliabe.silva.codechella.domain.models;

import java.util.List;

public record Traducao(List<Texto> translations) {

    public String getTexto(){
        return translations.get(0).text();
    }
}
