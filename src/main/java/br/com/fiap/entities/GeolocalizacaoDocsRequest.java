package br.com.fiap.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by danilopereira on 29/06/17.
 */
public class GeolocalizacaoDocsRequest {
    @JsonProperty("_id")
    private String id;
    private Float latitude;
    private Float longitude;
    private String markedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getMarkedAt() {
        return markedAt;
    }

    public void setMarkedAt(String markedAt) {
        this.markedAt = markedAt;
    }
}
