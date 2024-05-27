package br.com.literalura.core.repository;

import br.com.literalura.api.model.Autor;
import br.com.literalura.api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApiRepository extends JpaRepository<Livro, Long> {

    @Query("select l from Livro l where l.idioma = :idioma")
    List<Livro> findByIdiomaBySigla(@Param("idioma")String idioma);

    @Query("SELECT a FROM Livro l JOIN l.autores a WHERE :anoDigitado BETWEEN a.anoNascimento AND a.anoFalecimento")
    List<Autor> autoresVivosPorTempo(@Param("anoDigitado")int anoDigitado);

    @Query("SELECT a FROM Livro l JOIN l.autores a ")
    List<Autor> findAllAutor();

    @Query("SELECT l FROM Autor a JOIN a.livro l ")
    List<Livro> findAllLivro();
}
