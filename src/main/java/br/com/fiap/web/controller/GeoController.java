package br.com.fiap.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import br.com.fiap.entities.GeolocalizacaoDocsResponse;
import br.com.fiap.entities.Row;
import br.com.fiap.model.MarkerRequest;
import br.com.fiap.model.MarkerResponse;
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

    @RequestMapping(value = "/api/v1/registerMarker", method = RequestMethod.POST)
    public MarkerResponse registerMarker(@RequestBody @Valid MarkerRequest request) throws Exception {
        return cloudantRestClient.save(request);

    }

    @RequestMapping(value = "/api/v1/getMarkers", method = RequestMethod.GET)
    public List<MarkerResponse> getMarker() {
        return cloudantRestClient.list();
    }

    @RequestMapping(value = "/api/v1/getMarker/{id}", method = RequestMethod.GET)
    public MarkerResponse getMarkerById(@PathVariable String id) {
        return cloudantRestClient.getById(id);
    }

}
