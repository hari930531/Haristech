package com.fazon.haristech.model;

import lombok.*;

@Data
@Getter
@Setter
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
