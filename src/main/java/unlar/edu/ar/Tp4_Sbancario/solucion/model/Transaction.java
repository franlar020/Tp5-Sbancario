package unlar.edu.ar.Tp4_Sbancario.solucion.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
public class Transaction {

    private final Long id;
    private final TransactionType tipo;
    private final double monto;
    private final LocalDate fecha;
    private final String descripcion;

    public Transaction(Long id, TransactionType tipo, double monto,
                       LocalDate fecha, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}