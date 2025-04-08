package co.edu.uniquindio;

public enum EstadoOperativo {
    DISPONIBLE ("Disponible"),
    ENMISION ("En misión"),
    MANTENIMIENTO ("En mantenimiento");

    public final String estado;

    EstadoOperativo(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
