package co.edu.uniquindio;

public class VehiculoApoyo extends Vehiculo {
    //Atributos
    private String funcion;

    //Constructor
    public VehiculoApoyo(String id, String modelo, int anioMatricula, int kilometraje,
                         String estadoOperativo, int cantMisiones, String funcion) {
        super(id, modelo, anioMatricula, kilometraje, estadoOperativo, cantMisiones);
        this.funcion = funcion;
    }

    //getter y setter
    public String getFuncion() {
        return funcion;
    }
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
}
