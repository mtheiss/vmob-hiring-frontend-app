package dev.vmob.hiring.frontend;

import static org.mockito.Mockito.when;
import static org.springframework.http.ResponseEntity.ok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = FactController.class)
class FactControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FactService factService; 
	
	@Test
	void testFact() throws Exception {
		when(factService.getFact()).thenReturn(ok(ChuckNorrisFactDto.builder().fact("Lorem Ipsum").build()));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
			.andDo(MockMvcResultHandlers.print())
			.andExpectAll(
				MockMvcResultMatchers.status().isOk(),
				MockMvcResultMatchers.content().json("{\"body\":{\"fact\":\"Lorem Ipsum\"}}")
			);
			
	}
}
