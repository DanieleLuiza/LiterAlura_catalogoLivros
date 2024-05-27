package br.com.literalura.api.model;

import br.com.literalura.api.dto.DadosAutorDTO;
import br.com.literalura.api.dto.DadosLivroDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    private int numeroDownloads;
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores = new ArrayList<>();

    public Livro(){

    }
    public Livro(DadosLivroDTO livro) {
        this.titulo = livro.titulo();
        if (livro.idioma() != null || !livro.idioma().isEmpty() ) {
            this.idioma = livro.idioma().get(0);
        }

        this.numeroDownloads = livro.numeroDownloads();
        List<DadosAutorDTO> dadosAutor = livro.autores().stream().toList();
        dadosAutor.forEach(a -> autores.add(new Autor(a,this)));
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(int numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        List<String> autor = autores.stream()
                .map(x -> x.getNome())
                .collect(Collectors.toList());
        String retorno = "\n---- Livro ----"
                + "\nTítulo: "+ this.titulo
                +"\nAutor: "+ autor
                +"\nIdioma: " +this.idioma
                +"\nNúmero de Downloads: "+ this.numeroDownloads
                +"\n---------------";
        return retorno;
    }
}
