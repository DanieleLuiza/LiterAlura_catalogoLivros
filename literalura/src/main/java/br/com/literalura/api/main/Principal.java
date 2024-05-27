package br.com.literalura.api.main;

import br.com.literalura.core.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Principal {
    @Autowired
    private ApiService service;
    private Scanner leitura = new Scanner(System.in);
    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            System.out.println("Escolha o numero de sua opção: ");
            var menu = """
                    *******************************
                    1 - Buscar Livro pelo Título
                    2 - Listar Livros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores Vivos em um determinado Ano
                    5 - Listar Livros em um determinado Idioma
                                        
                    0 - Sair                                                                         
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {

                case 1:
                    service.buscarLivroPeloTitulo();
                    break;
                case 2:
                    service.listarLivrosRegistrados();
                    break;
                case 3:
                    service.listarAutoresRegistrados();
                    break;
                case 4:
                    service.listarAutoresVivosEmDeterminadoAno();
                    break;
                case 5:
                    listarLivrosEmDeterminadoIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    private void listarLivrosEmDeterminadoIdioma() {
        String opcao = "0";
        System.out.println("Insira o idioma para realizar a busca ");
        var menu = """
                *******************************
                es - espanhol
                en - inglês
                fr - francês
                pt - português
                """;

        System.out.println(menu);
        opcao = leitura.nextLine();
        String sigla = null;

        switch (opcao) {

            case "es":
                sigla = opcao;
                break;
            case "en":
                sigla = opcao;
                break;
            case "fr":
                sigla = opcao;
                break;
            case "pt":
                sigla = opcao;
                break;

            default:
                System.out.println("Opção inválida");
        }

       service.listarLivrosEmDeterminadoIdioma(sigla);
    }
}
