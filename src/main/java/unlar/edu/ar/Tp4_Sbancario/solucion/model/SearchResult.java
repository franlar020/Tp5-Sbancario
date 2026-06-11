package unlar.edu.ar.Tp4_Sbancario.solucion.model;

public record SearchResult(
        Transaction transaction,
        long tiempoBusquedaNs,
        int comparacionesRealizadas) {
}
