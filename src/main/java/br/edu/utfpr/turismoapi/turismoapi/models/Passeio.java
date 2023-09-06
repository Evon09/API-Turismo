package br.edu.utfpr.turismoapi.turismoapi.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_passeio")
public class Passeio extends BaseModel{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="agencia_id", nullable = false)
    private Pessoa agencia;

    private double preco;
    private String itinerario;
    private String destino;
    @ManyToMany(mappedBy = "passeios")
    private List<Reserva> reservas;


    
}
