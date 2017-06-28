package br.com.fiap.entities;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "_id", "_rev", "latitude", "longitude", "markedAt" })
public class Geolocalizacao {

	@JsonProperty("_id")
	private String id;
	@JsonProperty("_rev")
	private String rev;
	@JsonProperty("latitude")
	private Float latitude;
	@JsonProperty("longitude")
	private Float longitude;
	@JsonProperty("markedAt")
	private String markedAt;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("_id")
	public String getId() {
		return id;
	}

	@JsonProperty("_id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("_rev")
	public String getRev() {
		return rev;
	}

	@JsonProperty("_rev")
	public void setRev(String rev) {
		this.rev = rev;
	}

	@JsonProperty("latitude")
	public Float getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public Float getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("markedAt")
	public String getMarkedAt() {
		return markedAt;
	}

	@JsonProperty("markedAt")
	public void setMarkedAt(String markedAt) {
		this.markedAt = markedAt;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}