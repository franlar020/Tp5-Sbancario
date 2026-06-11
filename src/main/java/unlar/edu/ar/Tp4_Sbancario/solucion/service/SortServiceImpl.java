package unlar.edu.ar.Tp4_Sbancario.solucion.service;


import org.springframework.stereotype.Service;
import unlar.edu.ar.Tp4_Sbancario.solucion.model.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implementación de {@link SortService}.
 * Provee Bubble Sort O(n²) con conteo de operaciones y TimSort O(n log n) built-in.
 */
@Service
public class SortServiceImpl implements SortService {

    @Override
    public SortResult ordenarManual(List<Transaction> transacciones) {
        List<Transaction> lista = new ArrayList<>(transacciones);
        int comparaciones = 0;
        int intercambios = 0;
        int n = lista.size();

        long inicio = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;
                if (lista.get(j).getMonto() > lista.get(j + 1).getMonto()) {
                    Transaction temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                    intercambios++;
                }
            }
        }

        long tiempo = System.nanoTime() - inicio;
        return new SortResult(lista, tiempo, comparaciones, intercambios);
    }

    @Override
    public SortResult ordenarBuiltIn(List<Transaction> transacciones) {
        List<Transaction> lista = new ArrayList<>(transacciones);

        long inicio = System.nanoTime();
        lista.sort(Comparator.comparingDouble(Transaction::getMonto));
        long tiempo = System.nanoTime() - inicio;

        return new SortResult(lista, tiempo, 0, 0);
    }
}