package com.example.docker.sql;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository repo;

    @PostMapping
    public Book create(@RequestBody Book book) {
        return repo.save(book);
    }

    @GetMapping
    public List<Book> readAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Book read(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        Book b = repo.findById(id).orElseThrow();
        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        return repo.save(b);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

