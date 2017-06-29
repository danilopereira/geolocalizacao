package br.com.fiap.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"total_rows",
"offset",
"rows"
})
public class GeolocalizacaoDocsResponse {

@JsonProperty("total_rows")
private Integer totalRows;
@JsonProperty("offset")
private Integer offset;
@JsonProperty("rows")
private List<Row> rows = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("total_rows")
public Integer getTotalRows() {
return totalRows;
}

@JsonProperty("total_rows")
public void setTotalRows(Integer totalRows) {
this.totalRows = totalRows;
}

@JsonProperty("offset")
public Integer getOffset() {
return offset;
}

@JsonProperty("offset")
public void setOffset(Integer offset) {
this.offset = offset;
}

@JsonProperty("rows")
public List<Row> getRows() {
return rows;
}

@JsonProperty("rows")
public void setRows(List<Row> rows) {
this.rows = rows;
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