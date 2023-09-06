package br.edu.utfpr.turismoapi.turismoapi.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.edu.utfpr.turismoapi.turismoapi.utils.TipoPessoaEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_pessoa")
public class Pessoa extends BaseModel {
    private String nome;
    private String email;
    @Column(nullable = true)
    private LocalDateTime nascimento;
    private TipoPessoaEnum tipo;
    private String cpf;

    @OneToMany(mappedBy = "agencia")
    private List<Passeio> passeios;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservasCliente;

    @OneToMany(mappedBy = "agencia")
    private List<Reserva> reservasAgencia;

}
