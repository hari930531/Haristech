package com.fazon.haristech.model;

import lombok.*;

@Data
@Getter
@Setter
public class LoginUserRequest {
    private String email;
    private String password;
}
