package br.edu.utfpr.turismoapi.turismoapi.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_booking")
public class Booking extends BaseModel {
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id", nullable = false)
    private Person cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="agencia_id", nullable = false)
    private Person agencia;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "booking_tour",
            joinColumns = @JoinColumn(name = "passeio_id"),
            inverseJoinColumns = @JoinColumn(name = "reserva_id")
    )
    private List<Tour> passeios;

    @OneToOne(mappedBy = "reserva")
    private Payment pagamento;

    /* 

    public Booking(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dataInicial,
            LocalDateTime dataFinal, Person cliente, Person agencia) {
        super(id, createdAt, updatedAt);
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cliente = cliente;
        this.agencia = agencia;
    }
    */

}
