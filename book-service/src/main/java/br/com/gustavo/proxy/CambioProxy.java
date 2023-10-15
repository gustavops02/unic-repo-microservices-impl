package br.com.gustavo.proxy;

import br.com.gustavo.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio-service")
public interface CambioProxy {

    @GetMapping("/cambio-service/{amount}/{from}/{to}")
    public Cambio findCambio(@PathVariable Double amount,
                               @PathVariable String from,
                               @PathVariable String to);

}
