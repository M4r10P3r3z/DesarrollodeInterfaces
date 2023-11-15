package modelo;

import java.time.LocalDate;

public class Alquiler {
    private Long numeroExpediente;
    private LocalDate fechaEntrada;
    private Integer duracionEstimada;
    private Cliente cliente;
    private Vivienda vivienda;
    private Boolean estaCobrado;

    public Alquiler(Long numeroExpediente, LocalDate fechaEntrada, Integer duracionEstimada, Cliente cliente, Vivienda vivienda, Boolean estaCobrado) {
        this.numeroExpediente = numeroExpediente;
        this.fechaEntrada = fechaEntrada;
        this.duracionEstimada = duracionEstimada;
        this.cliente = cliente;
        this.vivienda = vivienda;
        this.estaCobrado = estaCobrado;
    }

    public Long getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(Long numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(Integer duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    public Boolean getEstaCobrado() {
        return estaCobrado;
    }

    public void setEstaCobrado(Boolean estaCobrado) {
        this.estaCobrado = estaCobrado;
    }

    @Override
    public String toString() {
        return "Alquiler(" + numeroExpediente + ", " + fechaEntrada + ", " + duracionEstimada + ", " + cliente +
                ", " + vivienda + ", " + ((estaCobrado) ? "Ya cobrado" : "Pendiente de cobro") + ")";
    }
}
