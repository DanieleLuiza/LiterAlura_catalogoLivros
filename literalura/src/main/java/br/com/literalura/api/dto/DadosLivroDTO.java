package br.com.literalura.api.dto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivroDTO(
        @JsonAlias("title")
        String titulo,
        @JsonAlias("languages")
        List<String> idioma,
        @JsonAlias("download_count")
        int numeroDownloads,
        @JsonAlias("authors")
        List<DadosAutorDTO> autores
)

{
}

