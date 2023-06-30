package com.geektext.apiproject.models;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "books")
@Data
public class Book {
    @Pattern(regexp = "\\d{13}", message = "ISBN must be exactly 13 digits")
    @NotEmpty(message = "Isbn must not be empty")
    @Id
    @Indexed(unique = true)
    private String isbn;

    @Size(max = 50)
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotEmpty(message = "Description must not be empty")
    private String description;

    @Size(max = 50)
    @NotEmpty(message = "Genre must not be empty")
    private String genre;

    @PositiveOrZero
    private BigDecimal cost;

    @NotEmpty(message = "Author ID must not be empty")
    private String authorId;

    @Size(max = 50)
    @NotEmpty(message = "Publisher must not be empty")
    private String publisher;

    @Min(value = 1900, message = "Year Published must not be empty")
    private Integer yearPublished;

    @Min(0)
    private int sold;

}