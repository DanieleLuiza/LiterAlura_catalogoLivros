package br.com.literalura.core.consumer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumoAPI {

    private static String URL_GUTENDEX = "https://gutendex.com/books?search=";

    public String buscarLivro(String livro ){
        String endereco = URL_GUTENDEX.concat(livro);
        try {
            ResponseEntity<String> response = null;
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>(headers);

            response = restTemplate.exchange(endereco, HttpMethod.GET, entity, String.class);

            String json =  response.getBody();

            return json;
        } catch (Exception e) {
            System.out.println("Erro ao encontrar o livro");
        }
        return null;
    }
}
