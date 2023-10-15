package br.com.gustavo.controller;


import br.com.gustavo.model.Book;
import br.com.gustavo.proxy.CambioProxy;
import br.com.gustavo.repository.BookRepository;
import br.com.gustavo.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy cambioProxy;

    @GetMapping("/{id}/{currency}")
    public Book findById(@PathVariable Long id,
                         @PathVariable String currency) {

        var book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));


        var cambio = cambioProxy.findCambio(book.getPrice(), "USD", currency);
        var port = environment.getProperty("local.server.port");
        book.setEnvironment("book port: " + port + " cambio port: " + cambio.getEnvironment());
        book.setPrice(cambio.getConvertedValue());

        return book;
    }
}
