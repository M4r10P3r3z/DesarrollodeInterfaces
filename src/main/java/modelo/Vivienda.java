package modelo;

public class Vivienda {
    private Long id;
    private String ubicacion;
    private Double superficie;
    private Integer numeroHabitaciones;
    private Integer numeroBanos;
    private Double precioAlquilerMensual;

    public Vivienda(Long id) {
        this.id = id;
    }

    public Vivienda(Long id, String ubicacion, Double superficie, Integer numeroHabitaciones,
                    Integer numeroBanos, Double precioAlquilerMensual) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.superficie = superficie;
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroBanos = numeroBanos;
        this.precioAlquilerMensual = precioAlquilerMensual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Integer getNumeroBanos() {
        return numeroBanos;
    }

    public void setNumeroBanos(Integer numeroBanos) {
        this.numeroBanos = numeroBanos;
    }

    public Double getPrecioAlquilerMensual() {
        return precioAlquilerMensual;
    }

    public void setPrecioAlquilerMensual(Double precioAlquilerMensual) {
        this.precioAlquilerMensual = precioAlquilerMensual;
    }

    @Override
    public String toString() {
        return "Vivienda(" + id + ", " + ubicacion + ", " + superficie + ", " + numeroHabitaciones +
                ", " + numeroBanos + ", " + precioAlquilerMensual + ")";
    }
}
