package modelo;

public class Vivienda {
    private final Long id;
    private final String ubicacion;
    private final Double superficie;
    private final Integer numeroHabitaciones;
    private final Integer numeroBanos;
    private final Double precioAlquilerMensual;

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

    @Override
    public String toString() {
        return "Vivienda(" + id + ", " + ubicacion + ", " + superficie + ", " + numeroHabitaciones +
                ", " + numeroBanos + ", " + precioAlquilerMensual + ")";
    }
}
