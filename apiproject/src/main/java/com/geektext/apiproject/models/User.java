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

    @Size(min = 8, max = 20)
    @NotEmpty(message = "Username must not be empty")
    @Id
    public final String username;

    @Size(min = 8, max = 20)
    @NotEmpty(message = "Password must not be empty")
    public final String password;

    @Size(max = 50)
    @Nullable
    public final String name;

    @Email
    @Size(max = 100)
    @Nullable
    public final String email;

    @Pattern(regexp = "\\d+\\s+[A-Za-z]+\\s+[A-za-z]+")
    @Nullable
    public final String address;

    @NotEmpty(message = "Roles must not be empty")
    private Set<String> roles;

}


