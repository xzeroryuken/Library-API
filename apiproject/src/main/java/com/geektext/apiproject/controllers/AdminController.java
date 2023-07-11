package com.geektext.apiproject.controllers;

import com.geektext.apiproject.models.Author;
import com.geektext.apiproject.models.Book;
import com.geektext.apiproject.repository.AuthorRepository;
import com.geektext.apiproject.repository.BookRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/authors")
    public ResponseEntity<?> createAuthor(@Valid @RequestBody Author author, BindingResult bindingResult) {
        // Check if the authenticated user has "ADMIN" role
        if (isAdminUser()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }

        return processAuthorCreation(author, bindingResult);
    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book, BindingResult bindingResult) {
        // Check if the authenticated user has the "ADMIN" role
        if (isAdminUser()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }

        return processBookCreation(book, bindingResult);
    }

    private boolean isAdminUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
    }

    private ResponseEntity<?> processAuthorCreation(Author author, BindingResult bindingResult) {
        // Checks for validation errors and binds it to a string to return as an error message.
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        // Creates Author if there are no validation errors.
        Author createdAuthor = authorRepository.save(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);

    }

    private ResponseEntity<?> processBookCreation(Book book, BindingResult bindingResult) {
        // Checks for validation errors and binds it to a string to return as an error message.
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        // Creates Book if there are no validation errors.
        Book createdBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }
}
