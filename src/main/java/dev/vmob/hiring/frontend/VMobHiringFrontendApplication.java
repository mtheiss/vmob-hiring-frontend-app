package dev.vmob.hiring.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import lombok.Generated;

@SpringBootApplication
@EnableConfigurationProperties(FrontendProperties.class)
public class VMobHiringFrontendApplication {
	@Bean
	public BackendClient backendClient(FrontendProperties properties) {
		WebClient webClient = WebClient.builder().baseUrl(properties.getBackendUrl()).build();
		
		HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
		
		return httpServiceProxyFactory.createClient(BackendClient.class);
	}

	@Generated
	public static void main(String[] args) {
		SpringApplication.run(VMobHiringFrontendApplication.class, args);
	}
}
