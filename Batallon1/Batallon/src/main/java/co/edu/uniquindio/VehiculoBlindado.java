package co.edu.uniquindio;

import java.util.Arrays;

//Clase hija
public class VehiculoBlindado extends Vehiculo {
    //Atributos
    private int nivelBlindaje;

    //Constructor
    public VehiculoBlindado(String id, String modelo, int anioMatricula, int kilometraje,
                            String estadoOperativo, int cantMisiones,int nivelBlindaje) {
        super(id, modelo, anioMatricula, kilometraje, estadoOperativo, cantMisiones);
        this.nivelBlindaje = nivelBlindaje;
    }

    //toString
    @Override
    public String toString() {
        return "ID vehiculo: "+id+'\n'+
                "Modelo del vehiculo: "+modelo+'\n'+
                "Año de matricula: "+anioMatricula+'\n'+
                "Kilometraje del vehiculo: "+kilometraje+'\n'+
                "Estado operativo: "+estadoOperativo+'\n'+
                "Cantidad de misiones completadas: "+cantMisiones+'\n'+
                "Nivel blindaje: "+nivelBlindaje;
    }

    //getter y setter
    public int getNivelBlindaje() {
        return nivelBlindaje;
    }
    public void setNivelBlindaje(int nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }
}
