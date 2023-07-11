package com.geektext.apiproject.models;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
public class User {
    @Id
    private Long id;

    @Size(min = 8, max = 20)
    @NotEmpty(message = "Username must not be empty")
    private final String username;

    @Size(min = 8, max = 20)
    @NotEmpty(message = "Password must not be empty")
    private final String password;

    @Size(max = 50)
    @Nullable
    private final String name;

    @Email
    @Size(max = 100)
    @Nullable
    private final String email;

    @Pattern(regexp = "\\d+\\s+[A-Za-z]+\\s+[A-za-z]+")
    @Nullable
    private final String address;
}


