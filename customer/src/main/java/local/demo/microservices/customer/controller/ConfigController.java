package local.demo.microservices.customer.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/config")
public class ConfigController {

	@Value("${datasource.provider}")
	private String provider;
	
	@Value("${datasource.url}")
	private String url;
	
	@PostConstruct
	public void init() {
		log.debug("CONFIG: provider = {}",provider);
		log.debug("CONFIG: url = {}",url);
	}
	
	@GetMapping
	public String[] config() {
		log.debug("Property 'datasource.provider' = {}", provider);
		log.debug("Property 'datasource.url' = {}", url);
		return new String[] { provider, url };
	}
}
