package br.edu.utfpr.turismoapi.turismoapi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PersonDTO {
    private String nome;
    private String email;
    private LocalDateTime nascimento;
    private String cpf;
}
