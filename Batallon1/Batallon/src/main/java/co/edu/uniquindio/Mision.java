package co.edu.uniquindio;

import java.time.LocalDate;

public record Mision(LocalDate fecha, String ubicacion, String personalAsignado, String vehiculoAsignado) {

    @Override
    public String toString() {
        return "fecha de la Mision: "+fecha+'\n'+
                "Ubicación: "+ubicacion+'\n'+
                "Persona asignado: "+personalAsignado+'\n'+
                "Vehiculo asignado: "+vehiculoAsignado;
    }
}
