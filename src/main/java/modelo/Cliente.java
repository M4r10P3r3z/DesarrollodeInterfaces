package modelo;

public class Cliente {
    private Long id;
    private String nombre;
    private String direccion;
    private String datosFacturacion;

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(Long id, String nombre, String direccion, String datosFacturacion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.datosFacturacion = datosFacturacion;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDatosFacturacion() {
        return datosFacturacion;
    }

    public void setDatosFacturacion(String datosFacturacion) {
        this.datosFacturacion = datosFacturacion;
    }

    @Override
    public String toString() {
        return "Cliente (" + id + ", " + nombre + ", " + direccion + ", " + datosFacturacion + ")";
    }
}
