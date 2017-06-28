package br.com.fiap.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class GeoMarker {
	
	public GeoMarker(Float longitude, Float latitude, Date markedAt){
		this.longitude = longitude;
		this.latitude = latitude;
		this.markedAt = markedAt;
	}
	
	@NotNull
	private Float longitude;
	
	@NotNull
	private Float latitude;
	
	@NotNull
	private Date markedAt;
	
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Date getMarkedAt() {
		return markedAt;
	}
	public void setMarkedAt(Date markedAt) {
		this.markedAt = markedAt;
	}
	
	

}
