package br.com.fiap.rest.client;

import br.com.fiap.entities.Geolocalizacao;
import br.com.fiap.entities.GeolocalizacaoDocsResponse;
import br.com.fiap.model.MarkerRequest;
import br.com.fiap.model.MarkerResponse;

import java.util.List;

public interface CloudantRestClient {
	
	public MarkerResponse save(MarkerRequest request) throws Exception;

	public MarkerResponse getById(String id);

	public List<MarkerResponse> list();

}
