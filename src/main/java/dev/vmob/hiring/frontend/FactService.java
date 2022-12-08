package dev.vmob.hiring.frontend;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FactService {
	private final BackendClient client;
	
	public ResponseEntity<ChuckNorrisFactDto> getFact() {
		return client.fact();
	}
}
