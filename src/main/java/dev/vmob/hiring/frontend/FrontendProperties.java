package dev.vmob.hiring.frontend;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "vmob.hiring.frontend")
public class FrontendProperties {
	private String backendUrl = "http://localhost:8080/";
}
