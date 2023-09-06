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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_reserva")
public class Reserva extends BaseModel {
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id", nullable = false)
    private Pessoa cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="agencia_id", nullable = false)
    private Pessoa agencia;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "reserva_passeio",
            joinColumns = @JoinColumn(name = "passeio_id"),
            inverseJoinColumns = @JoinColumn(name = "reserva_id")
    )
    private List<Passeio> passeios;

    @OneToOne(mappedBy = "reserva")
    private Pagamento pagamento;

    public Reserva(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dataInicial,
            LocalDateTime dataFinal, Pessoa cliente, Pessoa agencia) {
        super(id, createdAt, updatedAt);
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cliente = cliente;
        this.agencia = agencia;
    }

}
