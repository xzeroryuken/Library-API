package com.geektext.apiproject.controllers;

import com.geektext.apiproject.models.Author;
import com.geektext.apiproject.models.Book;
import com.geektext.apiproject.repository.AuthorRepository;
import com.geektext.apiproject.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("{authorId}/books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("authorId") String authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
