package br.com.literalura.core.service;

import br.com.literalura.api.dto.DadosLivroDTO;
import br.com.literalura.api.dto.DadosResultDTO;
import br.com.literalura.api.model.Autor;
import br.com.literalura.api.model.Livro;
import br.com.literalura.core.consumer.ConsumoAPI;
import br.com.literalura.core.converter.ConverteDados;
import br.com.literalura.core.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ApiService {
    @Autowired
    private ApiRepository repository;
    @Autowired
    private ConsumoAPI consumo;
    @Autowired
    private ConverteDados conversor = new ConverteDados();
    private List<Livro> livros = new ArrayList<>();
    private Scanner leitura = new Scanner(System.in);

    public void buscarLivroPeloTitulo() {
        DadosResultDTO result = getDadosLivro();
        List<DadosLivroDTO> dadosLivro = result.results().stream().toList();
        dadosLivro.forEach(l -> livros.add(new Livro(l)));
        try {
            livros.forEach(l -> repository.save(l));
            livros.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro ao salvar o livro!"+e);
        }

    }

    private DadosResultDTO getDadosLivro() {
        System.out.println("Insira o nome do Livro que deseja procurar: ");
        var nomeLivro = leitura.nextLine();
        System.out.println("Procurando o Livro: '"+ nomeLivro + "' no repositório do Gutendex");
        var json = consumo.buscarLivro(nomeLivro.toLowerCase());
        DadosResultDTO dados = conversor.obterDados(json, DadosResultDTO.class);
        System.out.println(dados);
        return dados;
    }
    public void listarLivrosRegistrados() {
        List<Livro> listaLivros = repository.findAllLivro();
        listaLivros.forEach(System.out::println);
    }
    public void listarAutoresRegistrados() {
        List<Autor> listaAutores = repository.findAllAutor();
        listaAutores.forEach(System.out::println);
    }
    public void listarAutoresVivosEmDeterminadoAno() {
        System.out.println("Digite o ano ");
        int anoDigitado = leitura.nextInt();
        List<Autor> listAuthors = repository.autoresVivosPorTempo(anoDigitado);
        listAuthors.forEach(System.out::println);
    }
    public void listarLivrosEmDeterminadoIdioma(String sigla) {
        List<Livro> listLivros =  repository.findByIdiomaBySigla(sigla);
        listLivros.forEach(System.out::println);
    }
}
