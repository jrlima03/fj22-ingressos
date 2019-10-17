package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Component
public class OmdbClient {
//Metodo Generico para pegar várias informações dependendo apenas das classes encontradas no pacote .ingresso.model :D
	//C ta vuando zézão
	public <MetodoGenerico> Optional<MetodoGenerico> resquest(Filme filme, Class<MetodoGenerico> tClass) {

		RestTemplate client = new RestTemplate();

		String titulo = filme.getNome().replace(" ", "+");

		String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s", titulo);

		try {
			return Optional.of(client.getForObject(url, tClass));
		} catch (RestClientException e) {
			return Optional.empty();
		}
		
		//Pega somente uma coisa por vez :D
//		try {
//			DetalhesDoFilme detalhesDoFilme = client.getForObject(url, DetalhesDoFilme.class);
//			return Optional.ofNullable(detalhesDoFilme);
//
//		} catch (RestClientException e) {
//			return Optional.empty();
//		}
	}
}
