package br.edu.utfpr.turismoapi.dto;

import lombok.Data;

@Data
public class AuthDTO {
    public String username;
    private String password;
}
