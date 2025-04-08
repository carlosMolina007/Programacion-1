package co.edu.uniquindio;

import java.util.Arrays;

//Clase hija
public class VehiculoTransporteTropas extends Vehiculo {
        //Atributos
        private int capacidadTropas;

        //Constructor
        public VehiculoTransporteTropas(String id, String modelo, int anioMatricula, int kilometraje,
                                        String estadoOperativo,int cantMisiones, int capacidadTropas) {
            super(id, modelo, anioMatricula, kilometraje, estadoOperativo, cantMisiones);
            this.capacidadTropas = capacidadTropas;}

    //ToString
    @Override
    public String toString() {
        return "ID vehiculo: "+id+'\n'+
                "Modelo del vehiculo: "+modelo+'\n'+
                "Año de matricula: "+anioMatricula+'\n'+
                "Kilometraje del vehiculo: "+kilometraje+'\n'+
                "Estado operativo: "+ estadoOperativo+'\n'+
                "Cantidad de misiones completadas: "+cantMisiones+'\n'+
                "Capacidad de tropas max: "+capacidadTropas;
    }

    //Getter y setter

        public int getCapacidadTropas() {
            return capacidadTropas;
        }

        public void setCapacidadTropas(int capacidadTropas) {
            this.capacidadTropas = capacidadTropas;
        }
}

