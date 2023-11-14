package modelo;

import java.time.LocalDate;

public class Alquiler {
    private final Long numeroExpediente;
    private final LocalDate fechaEntrada;
    private final Integer duracionEstimada;
    private final Cliente cliente;
    private final Vivienda vivienda;
    private final Boolean estaCobrado;

    public Alquiler(Long numeroExpediente, LocalDate fechaEntrada, Integer duracionEstimada, Cliente cliente, Vivienda vivienda, Boolean estaCobrado) {
        this.numeroExpediente = numeroExpediente;
        this.fechaEntrada = fechaEntrada;
        this.duracionEstimada = duracionEstimada;
        this.cliente = cliente;
        this.vivienda = vivienda;
        this.estaCobrado = estaCobrado;
    }

    @Override
    public String toString() {
        return "Alquiler(" + numeroExpediente + ", " + fechaEntrada + ", " + duracionEstimada + ", " + cliente +
                ", " + vivienda + ", " + ((estaCobrado) ? "Ya cobrado" : "Pendiente de cobro") + ")";
    }
}
