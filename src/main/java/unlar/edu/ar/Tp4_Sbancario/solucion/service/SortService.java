package unlar.edu.ar.Tp4_Sbancario.solucion.service;


import unlar.edu.ar.Tp4_Sbancario.solucion.model.Transaction;
import java.util.List;

public interface SortService {

    record SortResult(
        List<Transaction> listaOrdenada,
        long tiempoOrdenamientoNs,
        int comparaciones,
        int intercambios
    ) {}

    SortResult ordenarManual(List<Transaction> transacciones);

    SortResult ordenarBuiltIn(List<Transaction> transacciones);
}