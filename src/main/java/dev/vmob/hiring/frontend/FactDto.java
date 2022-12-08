package dev.vmob.hiring.frontend;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FactDto {
	private ChuckNorrisFactDto body;
	private Map<String, List<String>> headers;
}
