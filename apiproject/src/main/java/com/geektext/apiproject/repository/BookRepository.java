package com.geektext.apiproject.repository;

import org.springframework.cache.annotation.Cacheable;
import com.geektext.apiproject.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    @Override
    //@Cacheable("books") // Enable caching for this method
    @Query("{ }")
    List<Book> findAll();

    @Cacheable("books") // Enable caching for this method
    Book findBookByIsbn(String isbn);

    @Cacheable("books") // Enable caching for this method
    List<Book> findByAuthorId(String authorId);
}