package dev.vmob.hiring.frontend;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;

public interface BackendClient {
	@GetExchange(url = "/", accept = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ChuckNorrisFactDto> fact();
}
