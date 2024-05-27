package br.com.literalura.api.model;

import br.com.literalura.api.dto.DadosAutorDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;
    @ManyToOne
    private Livro livro;

    public Autor() {

    }
    public Autor(DadosAutorDTO autorData, Livro livro) {
        this.nome = autorData.nome();
        this.anoNascimento = autorData.anoNascimento();
        this.anoFalecimento = autorData.anoFalecimento();
        this.livro = livro;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    @Override
    public String toString() {
        String retorno = "\n---- Autor ----"
                +"\nNome: " + this.nome
                +"\nAno de Nascimento: " + this.anoNascimento
                +"\nAno de Falecimento: " + this.anoFalecimento
                +"\nLivros: " + this.livro.getTitulo()
                +"\n---------------";
        return retorno;
    }


}
