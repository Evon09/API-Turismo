package br.edu.utfpr.turismoapi.turismoapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID; 

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
public class BookingDTO {
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    private UUID clienteId; 
    private UUID agenciaId; 
    private List<UUID> passeiosIds; 
}