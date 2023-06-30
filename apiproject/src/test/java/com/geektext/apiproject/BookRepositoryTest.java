package com.geektext.apiproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.geektext.apiproject.repository.BookRepository;
import com.geektext.apiproject.models.Book;

import java.util.List;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindAllBooks() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books); // Print the retrieved books for verification
        // Add assertions to verify the correctness of the retrieved books
    }
}
