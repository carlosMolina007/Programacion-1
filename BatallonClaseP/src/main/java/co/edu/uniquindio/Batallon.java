package co.edu.uniquindio;

import javax.swing.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class Batallon {
    private String nombre;
    private String id;

    private LinkedList<Vehiculo> vehiculos;
    private LinkedList<VehiculoBlindado> listVehiculosBlindados;
    private LinkedList<TransporteTropas> listTransporteTropas;
    private LinkedList<VehiculoApoyo> listVehiculosApoyo;
    private LinkedList<Mision> listMisiones;

    public Batallon(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    //Se obtiene vehiculos con más de 50 misiones
    public LinkedList<Vehiculo> obtenerVehiculosCantMisiones() {
        LinkedList<Vehiculo> vehiculosMisionesCompletadas = new LinkedList<>();


        for (Vehiculo vehiculo : listVehiculosApoyo) {
            if (vehiculo.getMisionesCompletadas() > 50) {
                vehiculosMisionesCompletadas.add(vehiculo);
            }

        }
        for (Vehiculo vehiculo : listVehiculosBlindados) {
            if (vehiculo.getMisionesCompletadas() > 50) {
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        for (TransporteTropas transporteTropa : listTransporteTropas) {
            if (Vehiculo.getMisionesCompletadas() > 50) {
                vehiculosMisionesCompletadas.add(transporteTropa);
            }
        }
        return vehiculosMisionesCompletadas;


    }

    public boolean registrarMision (LocalDate fechaMision, String ubicacionMision, String idVehiculoMision, LinkedList personal){
        Boolean flag = false;
        String cantMisionesActuales = String.valueOf(vehiculos.size()+1);
        Mision newMision = new Mision(cantMisionesActuales,fechaMision,ubicacionMision);
        newMision.setPersonal(personal);
        for (Vehiculo vehiculoBlindado : listVehiculosBlindados ) {
            if(vehiculoBlindado.getId().equals(idVehiculoMision)){
                vehiculoBlindado.setMisionesCompletadas(vehiculoBlindado.getMisionesCompletadas()+1);
                newMision.setVehiculo(vehiculoBlindado);
                flag = true;
                break;
            }
        }for (Vehiculo vehiculoTropas : listTransporteTropas ) {
                if(vehiculoTropas.getId().equals(idVehiculoMision)){
                    vehiculoTropas.setMisionesCompletadas(vehiculoTropas.getMisionesCompletadas()+1);
                    newMision.setVehiculo(vehiculoTropas);
                    flag = true;
                    break;
                }
            }
        for (Vehiculo vehiculoApoyo : listVehiculosApoyo ) {
            if(vehiculoApoyo.getId().equals(idVehiculoMision)){
                vehiculoApoyo.setMisionesCompletadas(vehiculoApoyo.getMisionesCompletadas()+1);
                newMision.setVehiculo(vehiculoApoyo);
                flag = true;
                break;
            }
        }
        if(flag){
            listMisiones.add(newMision);
        }
        return flag;
    }

    public String promedioKilometrajeTipoVehiculo(){
        String mensajePromedio = "";
        int sumaKmApoyo = 0;
        int sumaKmBlindado = 0;
        int sumaKmTropas = 0;
        //Obtenemos el kilometraje total de cada tipo de vehiculo
        for (Vehiculo vehiculoApoyo : listVehiculosApoyo) {
            sumaKmApoyo += vehiculoApoyo.getKilometraje();
        }
        for (Vehiculo vehiculoBlindado : listVehiculosBlindados) {
            sumaKmBlindado += vehiculoBlindado.getKilometraje();
        }
        for (TransporteTropas vehiculoTransporteTropas : listTransporteTropas) {
            sumaKmTropas += vehiculoTransporteTropas.getKilometraje();
        }
        //Sacamos el promedio de cada uno
        int promedioApoyo = listVehiculosApoyo.isEmpty() ? 0 : sumaKmApoyo / listVehiculosApoyo.size();
        int promedioBlindado = listVehiculosBlindados.isEmpty() ? 0 : sumaKmBlindado / listVehiculosBlindados.size();
        int promedioTransporteTropas = listTransporteTropas.isEmpty() ? 0 : sumaKmTropas / listTransporteTropas.size();

        //Realizamos el mensaje para retornarlo
        mensajePromedio = "Kilometraje promedio por cada tipo de vehiculo:\n\n" +
                "Kilometraje promedio vehiculos de apoyo: "+promedioApoyo+'\n'+
                "Kilometraje promedio vehiculos blindados: "+promedioBlindado+'\n'+
                "Kilometraje promedio vehiculos transportadores de tropas: "+promedioTransporteTropas;
        return mensajePromedio;
    }

    public LinkedList<Mision> obtenerMisionesUbicacion(String ubicacionMision, LocalDate fechaMisionInicio, LocalDate fechaMisionFin){
        LinkedList<Mision> misionesFiltradas = new LinkedList<>();
        for (Mision mision : listMisiones) {
            if (mision.getUbicacion().equalsIgnoreCase(ubicacionMision)) {
                LocalDate fechaMision = mision.getFecha();
                if ((fechaMision.isEqual(fechaMisionInicio) || fechaMision.isAfter(fechaMisionInicio)) &&
                        (fechaMision.isEqual(fechaMisionFin) || fechaMision.isBefore(fechaMisionFin))) {
                    misionesFiltradas.add(mision);
                }
            }
        }

        return misionesFiltradas;
    }

    public Vehiculo vehiculoMayorCantMisiones(){
        Vehiculo vehiculoMaxCantMisiones = null;
        int maxCantMisiones = 0;
        for (Vehiculo vehiculoApoyo : listVehiculosApoyo) {
            if (vehiculoApoyo.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = vehiculoApoyo.getMisionesCompletadas();
                vehiculoMaxCantMisiones = vehiculoApoyo;
            }
        }for (Vehiculo vehiculoBlindado : listVehiculosBlindados) {
            if (vehiculoBlindado.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = vehiculoBlindado.getMisionesCompletadas();
                vehiculoMaxCantMisiones = vehiculoBlindado;
            }
        }for (TransporteTropas transporteTropas : listTransporteTropas) {
            if(transporteTropas.getMisionesCompletadas() > maxCantMisiones){
                maxCantMisiones = transporteTropas.getMisionesCompletadas();
                vehiculoMaxCantMisiones = transporteTropas;
            }
        }
        return vehiculoMaxCantMisiones;
    }


}