package br.com.literalura.core.converter;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);

}

