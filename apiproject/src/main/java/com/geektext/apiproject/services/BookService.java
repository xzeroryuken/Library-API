package com.geektext.apiproject.services;

import com.geektext.apiproject.models.Book;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geektext.apiproject.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }


}