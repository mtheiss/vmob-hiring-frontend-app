package dev.vmob.hiring.frontend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

class FactServiceTest {

	@Test
	void factTest() {
		// given
		BackendClient client = Mockito.mock(BackendClient.class);
		ChuckNorrisFactDto factDto = ChuckNorrisFactDto.builder().fact("Lorem Ipsum").build();
		Mockito.when(client.fact()).thenReturn(ResponseEntity.ok(factDto));
		FactService sut = new FactService(client);
		
		// when
		ResponseEntity<ChuckNorrisFactDto> responseEntity = sut.getFact();
		
		// then
		assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
		assertThat(responseEntity.getBody()).isEqualTo(factDto);
	}
}
