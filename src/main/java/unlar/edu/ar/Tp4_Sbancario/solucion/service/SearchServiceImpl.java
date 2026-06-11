package unlar.edu.ar.Tp4_Sbancario.solucion.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.Tp4_Sbancario.solucion.model.SearchResult;
import unlar.edu.ar.Tp4_Sbancario.solucion.model.Transaction;

import java.util.List;

/**
 * Implementación de {@link SearchService}.
 * Provee búsqueda lineal O(n) y binaria O(log n) con métricas de ejecución.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResult buscarPorIdLineal(List<Transaction> transacciones, Long id) {
        int comparaciones = 0;
        long inicio = System.nanoTime();

        for (Transaction t : transacciones) {
            comparaciones++;
            if (t.getId().equals(id)) {
                long tiempo = System.nanoTime() - inicio;
                return new SearchResult(t, tiempo, comparaciones);
            }
        }

        long tiempo = System.nanoTime() - inicio;
        return new SearchResult(null, tiempo, comparaciones);
    }

    @Override
    public SearchResult buscarPorIdBinario(List<Transaction> transacciones, Long id) {
        int comparaciones = 0;
        long inicio = System.nanoTime();

        int izquierda = 0;
        int derecha = transacciones.size() - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            Transaction t = transacciones.get(medio);
            comparaciones++;

            int cmp = t.getId().compareTo(id);

            if (cmp == 0) {
                long tiempo = System.nanoTime() - inicio;
                return new SearchResult(t, tiempo, comparaciones);
            } else if (cmp < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        long tiempo = System.nanoTime() - inicio;
        return new SearchResult(null, tiempo, comparaciones);
    }
}