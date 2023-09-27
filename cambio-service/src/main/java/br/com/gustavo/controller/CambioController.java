package br.com.gustavo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavo.model.Cambio;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/{amount}/{from}/{to}")
	public Cambio findCambio(@PathVariable BigDecimal amount,
							@PathVariable String from,
							@PathVariable String to) {
		
		String port = environment.getProperty("local.server.port");
		
		return new Cambio(1L, from, to, amount, BigDecimal.ONE, port);
		
	}
	
}
