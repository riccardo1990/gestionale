package com.trenota.gestionale.web.rest;

import com.trenota.gestionale.model.Book;
import com.trenota.gestionale.service.BookService;
import com.trenota.gestionale.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class BookResource {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<Book> createCustomer(@Valid @RequestBody Book book) throws URISyntaxException {
        if (book.getId() != null) {
            //TODO: manage exception
        }
        Book result = bookService.save(book);
        return ResponseEntity.created(new URI("/api/books/" + result.getId()))
                .body(result);
    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateCustomer(@Valid @RequestBody Book book) throws URISyntaxException {
        if (book.getId() == null) {
            //TODO: manage exception
        }
        Book result = bookService.save(book);
        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllCustomers(Pageable pageable) {
        Page<Book> page = bookService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), null, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getCustomer(@PathVariable Long id) {
        Optional<Book> book = bookService.findOne(id);
        return ResponseUtil.wrapOrNotFound(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
