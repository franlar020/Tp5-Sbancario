package unlar.edu.ar.Tp4_Sbancario.solucion.service;

import unlar.edu.ar.Tp4_Sbancario.solucion.model.SearchResult;
import unlar.edu.ar.Tp4_Sbancario.solucion.model.Transaction;
import java.util.List;

public interface SearchService {

    SearchResult buscarPorIdLineal(List<Transaction> transacciones, Long id);

    SearchResult buscarPorIdBinario(List<Transaction> transacciones, Long id);
}