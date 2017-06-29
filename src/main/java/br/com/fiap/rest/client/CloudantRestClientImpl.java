package br.com.fiap.rest.client;

import br.com.fiap.entities.*;
import br.com.fiap.model.GeoMarker;
import br.com.fiap.model.MarkerRequest;
import br.com.fiap.model.MarkerResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
	public MarkerResponse save(MarkerRequest request) throws Exception {
		MarkerResponse response = new MarkerResponse();
		String uri = baseUrl.concat("/geolocalizacao");

		GeolocalizacaoDocsRequest docsRequest = new GeolocalizacaoDocsRequest();
		docsRequest.setId(UUID.randomUUID().toString());
		docsRequest.setLatitude(request.getLatitude());
		docsRequest.setLongitude(request.getLongitude());
		docsRequest.setMarkedAt(String.valueOf(System.currentTimeMillis()));

		HttpEntity<GeolocalizacaoDocsRequest> entity = new HttpEntity<GeolocalizacaoDocsRequest>(docsRequest, httpHeaders);

		ResponseEntity<CreateDocumentResponse> exchange = restTemplate.exchange(uri, HttpMethod.POST, entity, CreateDocumentResponse.class);

		CreateDocumentResponse body = exchange.getBody();

		return this.getById(body.getId());

	}

	@Override
	public MarkerResponse getById(String id) {
		MarkerResponse response = new MarkerResponse();
		String uri = baseUrl.concat("/geolocalizacao/" + id);
		Geolocalizacao geolocalizacao = null;
		HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);
		ResponseEntity<Geolocalizacao> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity,
				Geolocalizacao.class);
		geolocalizacao = exchange.getBody();

		response.setId(geolocalizacao.getId());
		response.setLatitude(geolocalizacao.getLatitude());
		response.setLongitude(geolocalizacao.getLongitude());
		response.setMarkedAt(geolocalizacao.getMarkedAt());

		return response;
	}

	@Override
	public List<MarkerResponse> list() {
		List<MarkerResponse> response = new ArrayList<MarkerResponse>();
		String uri = baseUrl.concat("/geolocalizacao/_all_docs");
		GeolocalizacaoDocsResponse docs = null;
		HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);
		ResponseEntity<GeolocalizacaoDocsResponse> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, GeolocalizacaoDocsResponse.class);
		docs = exchange.getBody();

		for (Row row : docs.getRows()) {
			response.add(this.getById(row.getId()));

		}

		return response;
	}

}
