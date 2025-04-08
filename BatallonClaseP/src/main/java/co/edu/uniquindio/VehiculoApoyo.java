package co.edu.uniquindio;

public class VehiculoApoyo extends Vehiculo {
public tipoFuncion tipoFuncion;
    public VehiculoApoyo(String id, String modelo, int fechaFabricacion, double kilometraje, int misionesCompletadas, EstadoOperativo estado, tipoFuncion tipoFuncion) {
        super(id, modelo, fechaFabricacion, kilometraje, misionesCompletadas, estado, tipoFuncion);
        this.tipoFuncion = tipoFuncion;
    }

    public tipoFuncion getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(tipoFuncion tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }

    @Override
    public void desplazamiento() {

    }
}
