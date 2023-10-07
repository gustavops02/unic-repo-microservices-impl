package br.com.gustavo.controller;


import br.com.gustavo.model.Book;
import br.com.gustavo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @GetMapping("/{id}/{currency}")
    public Book findById(@PathVariable Long id,
                         @PathVariable String currency) {

        var book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));



        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port);

        return book;
   }
}
