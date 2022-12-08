package dev.vmob.hiring.frontend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FactController {
	private final FactService service;

	@GetMapping(path = "/")
	public FactDto fact() {
		ResponseEntity<ChuckNorrisFactDto> responseEntity = service.getFact();
		return FactDto.builder().body(responseEntity.getBody()).headers(responseEntity.getHeaders()).build();
	}
}
