package br.com.fiap.configuration;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.rest.client.CloudantRestClient;
import br.com.fiap.rest.client.CloudantRestClientImpl;

@Configuration
public class ApplicationConfiguration {
	@Value("${cloudant.url}")
	public String baseUrl;
	
	@Value("${cloudant.username}")
	public String user;
	
	@Value("${cloudant.password}")
	public String password;
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public CloudantRestClient cloudantRestClient(RestTemplate restTemplate){
		HttpHeaders headers = new HttpHeaders();
		byte[] toEncode = user.concat(":").concat(password).getBytes();
		headers.add("Authorization", "Basic ".concat(Base64.getEncoder().encodeToString(toEncode)));
		
		return new CloudantRestClientImpl(restTemplate, headers, baseUrl);
	}

}
