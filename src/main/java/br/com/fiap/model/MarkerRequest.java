package br.com.fiap.model;

import javax.validation.constraints.NotNull;

/**
 * Created by danilopereira on 29/06/17.
 */
public class MarkerRequest {
    @NotNull
    private Float latitude;
    @NotNull
    private Float longitude;

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
}
