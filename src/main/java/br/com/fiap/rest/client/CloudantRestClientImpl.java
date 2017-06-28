package br.com.fiap.rest.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.entities.Geolocalizacao;

public class CloudantRestClientImpl implements CloudantRestClient {
	RestTemplate restTemplate;
	HttpHeaders httpHeaders;
	String baseUrl;

	public CloudantRestClientImpl(RestTemplate restTemplate, HttpHeaders httpHeaders, String baseUrl) {
		this.restTemplate = restTemplate;
		this.httpHeaders = httpHeaders;
		this.baseUrl = baseUrl;
	}

	@Override
	public void save(Geolocalizacao geolocalizacao) throws Exception {
		String uri = baseUrl.concat("geolocalizacao/");
		URI url = new URI(baseUrl);
		Geolocalizacao object = restTemplate.postForObject(url, geolocalizacao, Geolocalizacao.class);
	}

	@Override
	public Geolocalizacao getById(String id) {
		String uri = baseUrl.concat("/geolocalizacao/" + id);
		Geolocalizacao geolocalizacao = null;
		HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);
		ResponseEntity<Geolocalizacao> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity,
				Geolocalizacao.class);
		geolocalizacao = exchange.getBody();

		return geolocalizacao;
	}

}
