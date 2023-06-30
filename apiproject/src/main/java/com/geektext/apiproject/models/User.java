package com.geektext.apiproject.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {

    @Id
    public final String username;

    @NotEmpty
    public final String password;

    @NotEmpty
    public final String name;

    @NotEmpty
    public final String email;

    @NotEmpty
    public final String address;

}


