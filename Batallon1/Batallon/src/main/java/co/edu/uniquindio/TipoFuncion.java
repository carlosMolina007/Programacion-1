package co.edu.uniquindio;

public enum TipoFuncion {
    LOGISTICA ("Función logística"),
    COMUNICACIONES ("Función comunicativa"),
    MEDICO ("Función médica");

    public final String tipoFuncion;

    TipoFuncion(String tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }
    public String getTipoFuncion() {
        return tipoFuncion;
    }
}
