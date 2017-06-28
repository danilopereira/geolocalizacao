package br.com.fiap.web.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.entities.Geolocalizacao;
import br.com.fiap.model.GeoMarker;
import br.com.fiap.rest.client.CloudantRestClient;

@RestController
public class GeoController {
	@Autowired
	CloudantRestClient cloudantRestClient;
	
	@RequestMapping(value="/api/v1/registerMaker", method=RequestMethod.POST)
	public void registerMarker(@RequestBody @Valid GeoMarker marker){
		
	}
	
	@RequestMapping(value="/api/v1/getMakers", method=RequestMethod.GET)
	public List<GeoMarker> getMarker(){
		return Arrays.asList(new GeoMarker(new Float(123.0), new Float(0.0), new Date(System.currentTimeMillis())));
	}
	
	@RequestMapping(value="/api/v1/getMaker/{id}", method=RequestMethod.GET)
	public GeoMarker getMarkerById(@PathVariable String id){
		Geolocalizacao geolocalizacao = cloudantRestClient.getById(id);
		return new GeoMarker(geolocalizacao.getLatitude(), geolocalizacao.getLongitude(), new Date(System.currentTimeMillis()));
	}

}
