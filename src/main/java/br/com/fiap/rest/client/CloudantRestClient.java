package br.com.fiap.rest.client;

import br.com.fiap.entities.Geolocalizacao;

public interface CloudantRestClient {
	
	public void save(Geolocalizacao geolocalizacao) throws Exception;
	
	public Geolocalizacao getById(String id);

}
