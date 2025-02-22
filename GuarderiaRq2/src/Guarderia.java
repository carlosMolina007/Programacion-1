import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Guarderia {

    //Atributos
    private String nombre;
    private String nit;
    private ArrayList<Estudiante> listEstudiantes;
    private ArrayList<Estudiante> estudianteMayor5anios;




    public void agregarEstudiante(Estudiante newEstudiante) {
        listEstudiantes.add(newEstudiante);
    }

    public void eliminarEstudiante(Estudiante estudianteEliminar) {
        listEstudiantes.remove(estudianteEliminar);
    }

    public void actualizarEstudiante(Estudiante estudianteActualizar) {
        for (Estudiante indexEstudiante : listEstudiantes) {
            if (indexEstudiante.getIdentificacion().equals(estudianteActualizar.getIdentificacion())) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nombre a actualizar");
                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad actual"));
                String nuevoGenero = JOptionPane.showInputDialog("Ingrese el genero actual");
                String nuevasAlergias = JOptionPane.showInputDialog("Ingrese si tiene nuevas alergias");
                String actualNombreAcudiente = JOptionPane.showInputDialog("Ingrese el nombre del actual acudiente");
                String actualNumAcudiente = JOptionPane.showInputDialog("Ingrese el numero de contacto del actual acudiente");

                estudianteActualizar.setNombre(nuevoNombre);
                estudianteActualizar.setEdad(nuevaEdad);
                estudianteActualizar.setGenero(nuevoGenero);
                estudianteActualizar.setAlergias(nuevasAlergias);
                estudianteActualizar.setNombreAcudiente(actualNombreAcudiente);
                estudianteActualizar.setNumAcudiente(actualNumAcudiente);
                break;
            }
        }
    }

    public void listarEstudiantes() {
        for (Estudiante estudiante : listEstudiantes) {
            System.out.println("Estudiante "+listEstudiantes.indexOf(estudiante)+" "+estudiante);
        }
    }

    public void estudiantesMayores5Anios() {
        estudianteMayor5anios.clear();
        for (Estudiante estudiante : listEstudiantes){
            if (estudiante.getEdad() > 5){
                estudianteMayor5anios.add(estudiante);
            }
        }
    }

    //Constructor
    public Guarderia(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listEstudiantes = new ArrayList<>();
        this.estudianteMayor5anios = new ArrayList<>();
    }

    //Setter y Getter

    public ArrayList<Estudiante> getEstudianteMayor5anios() {
        return estudianteMayor5anios;
    }

    public void setEstudianteMayor5anios(ArrayList<Estudiante> estudianteMayor5anios) {
        this.estudianteMayor5anios = estudianteMayor5anios;
    }


    public ArrayList<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(ArrayList<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}