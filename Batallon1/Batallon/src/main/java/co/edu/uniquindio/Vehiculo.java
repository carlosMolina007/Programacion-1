package co.edu.uniquindio;

import javax.swing.*;
import java.util.Arrays;

//Clase padre
public class Vehiculo {

    //Atributos
    protected String id;
    protected String modelo;
    protected int anioMatricula;
    protected int kilometraje;
    protected String estadoOperativo;
    protected int cantMisiones;

    //Constructor
    public Vehiculo(String id, String modelo, int anioMatricula, int kilometraje,  String estadoOperativo, int cantMisiones) {
        this.id = id;
        this.modelo = modelo;
        this.anioMatricula = anioMatricula;
        this.kilometraje = kilometraje;
        this.estadoOperativo = estadoOperativo;
        this.cantMisiones = cantMisiones;
    }

    //ToString
    @Override
    public String toString() {
        return "ID vehiculo: "+id+'\n'+
                "Modelo del vehiculo: "+modelo+'\n'+
                "Año de matricula: "+anioMatricula+'\n'+
                "Kilometraje del vehiculo: "+kilometraje+'\n'+
                "Estado operativo: "+estadoOperativo+'\n'+
                "Cantidad de misiones completadas: "+cantMisiones;
    }

    //getter's and setter's

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioMatricula() {
        return anioMatricula;
    }

    public void setAnioMatricula(int anioMatricula) {
        this.anioMatricula = anioMatricula;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(String estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }
    public int getCantMisiones() {
        return cantMisiones;
    }
    public void setCantMisiones(int cantMisiones) {
        this.cantMisiones = cantMisiones;
    }
}
