package com.simplilearn.restservice;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestServiceApplicationTests {

	@Test
	void testRootPath() {
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:8080";
	    URI uri;
		try {
			uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			Assertions.assertEquals(200, result.getStatusCodeValue());
			// Assertions.assertEquals(true, result.getBody().contains("Hello there"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			Assertions.fail("Error, could not locate URI");
		}
	}
}
