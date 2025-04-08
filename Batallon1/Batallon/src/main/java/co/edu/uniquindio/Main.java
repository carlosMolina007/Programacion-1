package co.edu.uniquindio;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Icon icono = new ImageIcon(Main.class.getClassLoader().getResource("iconoBatallon.png"));
        Image image = ((ImageIcon) icono).getImage();//Obtenemos la imagen
        Image newImage = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);//La re-escalamos
        icono = new ImageIcon(newImage);
        Batallon newBatallon = new Batallon("BATALLÓN QUINDIO", "900.32.554.1");
        String[] options = {
                "Agregar un vehiculo",
                "Lista de vehiculos",
                "Eliminar un vehiculo",
                "Actualizar un vehiculo",
                "Obtener vehiculos con más de 50 misiones",
                "Lista de misiones",
                "Salir"
        };
        while (true) {
            String option = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción",
                    "BIENVENIDO AL MENU DEL " + newBatallon.getNombre(),
                    JOptionPane.PLAIN_MESSAGE,
                    icono,
                    options,
                    options[0]);
            if (option == null || option.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;
            }
            String[] optionsVehiculo = {
                    "Vehiculo Blindado",
                    "Vehiculo transportador de tropas",
                    "Vehiculo de apoyo"
            };
            switch (option) {
                case "Agregar un vehiculo":
                    String optionVehiculo = (String) JOptionPane.showInputDialog(
                            null,
                            "¿Qué tipo de vehiculo desea agreagar?",
                            "TIPOS DE VEHICULOS",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            optionsVehiculo,
                            optionsVehiculo[0]);
                    switch (optionVehiculo) {
                        case "Vehiculo Blindado":
                            String id = JOptionPane.showInputDialog(null, "Ingrese el ID del vehiculo");
                            String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo del vehiculo");
                            int anioMatricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de matricula del vehiculo"));
                            int kilometraje = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el kilometraje del vehiculo"));
                            String[] optionEstadoOperativo = {
                                    "Disponible",
                                    "En una misión",
                                    "En mantenimiento"
                            };
                            String estadoOperativo = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Seleccion el estado actual del vehiculo",
                                    "ESTADOS DEL VEHICULO",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    optionEstadoOperativo,
                                    optionEstadoOperativo[0]);

                            if (estadoOperativo.equals("Disponible")) {
                                EstadoOperativo.DISPONIBLE.getEstado();
                            } else if (estadoOperativo.equals("En una misión")) {
                                EstadoOperativo.ENMISION.getEstado();
                            } else {
                                EstadoOperativo.MANTENIMIENTO.getEstado();
                            }
                            int cantMisiones = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el cantidad de misiones completadas"));
                            int nivelBlindaje = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nivel de blindaje del vehiculo"));

                            Vehiculo vehiculoBlindado = new VehiculoBlindado(id, modelo, anioMatricula, kilometraje,
                                    estadoOperativo, cantMisiones, nivelBlindaje);
                            JOptionPane.showMessageDialog(null, "Vehiculo agregado con éxito");
                            break;

                        case "Vehiculo transportador de tropas":
                            String idTropas = JOptionPane.showInputDialog(null, "Ingrese el ID del vehiculo");
                            String modeloTropas = JOptionPane.showInputDialog(null, "Ingrese el modelo del vehiculo");
                            int anioMatriculaTropas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de matricula del vehiculo"));
                            int kilometrajeTropas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el kilometraje del vehiculo"));
                            String[] optionEstadoOperativo1 = {
                                    "Disponible",
                                    "En una misión",
                                    "En mantenimiento"
                            };
                            String estadoOperativo1 = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Seleccion el estado actual del vehiculo",
                                    "ESTADOS DEL VEHICULO",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    optionEstadoOperativo1,
                                    optionEstadoOperativo1[0]);

                            if (estadoOperativo1.equals("Disponible")) {
                                EstadoOperativo.DISPONIBLE.getEstado();
                            } else if (estadoOperativo1.equals("En una misión")) {
                                EstadoOperativo.ENMISION.getEstado();
                            } else {
                                EstadoOperativo.MANTENIMIENTO.getEstado();
                            }
                            int cantMisionesTropas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el cantidad de misiones completadas"));
                            int cantTropas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la máxima cantidad de tropas que puede abordar"));

                            Vehiculo vehiculoTropas = new VehiculoTransporteTropas(idTropas, modeloTropas, anioMatriculaTropas, kilometrajeTropas,
                                    estadoOperativo1, cantMisionesTropas, cantTropas);
                            JOptionPane.showMessageDialog(null, "Vehiculo agregado con éxito");
                            break;

                        default:
                            //case "Vehiculo de apoyo":
                            String idApoyo = JOptionPane.showInputDialog(null, "Ingrese el ID del vehiculo");
                            String modeloApoyo = JOptionPane.showInputDialog(null, "Ingrese el modelo del vehiculo");
                            int anioMatriculaApoyo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de matricula del vehiculo"));
                            int kilometrajeApoyo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el kilometraje del vehiculo"));
                            String[] optionEstadoOperativo2 = {
                                    "Disponible",
                                    "En una misión",
                                    "En mantenimiento"
                            };
                            String estadoOperativo2 = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Seleccion el estado actual del vehiculo",
                                    "ESTADOS DEL VEHICULO",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    optionEstadoOperativo2,
                                    optionEstadoOperativo2[0]);

                            if (estadoOperativo2.equals("Disponible")) {
                                EstadoOperativo.DISPONIBLE.getEstado();
                            } else if (estadoOperativo2.equals("En una misión")) {
                                EstadoOperativo.ENMISION.getEstado();
                            } else {
                                EstadoOperativo.MANTENIMIENTO.getEstado();
                            }
                            int cantMisionesApoyo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el cantidad de misiones completadas"));
                            String[] optionFuncion = {
                                    "Logística",
                                    "Comunicaciones",
                                    "Medica"
                            };
                            String tipoFuncion = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Seleccion qué función cumple este vehiculo de apoyo",
                                    "FUNCIONES",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    optionFuncion,
                                    optionFuncion[0]);

                            if (tipoFuncion.equals("Disponible")) {
                                EstadoOperativo.DISPONIBLE.getEstado();
                            } else if (tipoFuncion.equals("En una misión")) {
                                EstadoOperativo.ENMISION.getEstado();
                            } else {
                                EstadoOperativo.MANTENIMIENTO.getEstado();
                            }

                            Vehiculo vehiculoApoyo = new VehiculoApoyo(idApoyo, modeloApoyo, anioMatriculaApoyo, kilometrajeApoyo,
                                    estadoOperativo2, cantMisionesApoyo, tipoFuncion);
                            JOptionPane.showMessageDialog(null, "Vehiculo agregado con éxito");
                            break;
                    }
                    break;
                case "Lista de vehiculos":
                    Vehiculo[] listaVehiculos = newBatallon.listVehiculos();
                    JOptionPane.showMessageDialog(null, listaVehiculos);
                    break;
            }

        }
    }
}
