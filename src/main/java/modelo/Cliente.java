package modelo;

public class Cliente {
    private final Long id;
    private final String nombre;
    private final String direccion;
    private final String datosFacturacion;

    public Cliente(Long id, String nombre, String direccion, String datosFacturacion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.datosFacturacion = datosFacturacion;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente (" + id + ", " + nombre + ", " + direccion + ", " + datosFacturacion + ")";
    }
}
