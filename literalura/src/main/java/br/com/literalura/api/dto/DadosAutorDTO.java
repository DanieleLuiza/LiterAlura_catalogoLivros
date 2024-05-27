package br.com.literalura.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutorDTO(
        @JsonAlias("name")
        @Column(unique = true)
        String nome,
        @JsonAlias("birth_year")
        int anoNascimento,
        @JsonAlias("death_year")
        int anoFalecimento) {
}

