import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Guarderia {
        //Agregar: Obtener todas las edades mayores a un número ingresado
        //Cuantas veces está una edad N en una lista de Estudiantes
        //Obtener la edad más repetida
        //Obtener el nombre más largo
        //Obtener una lista de los nombres que empiecen por Char (caracter) ingresado
        //Atributos

        private char caracter;
        private int edadMinima;
        private int edadBuscar;
        private String nombre;
        private String nit;
        private Estudiante[] listaEstudiantes;

        public int ultimaPosicion(){
            for (int i = 0; i < listaEstudiantes.length; i++){
                if (listaEstudiantes[i] == null){
                    return i;
                }
            }return -1;
        }

        public Boolean agregarEstudiante(Estudiante newEstudiante) {
            boolean flag = true;
            for (int i = 0; i < listaEstudiantes.length; i++) {
                if (listaEstudiantes[i] != null && listaEstudiantes[i].getIdentificacion().equals(newEstudiante.getIdentificacion())) {
                    flag = false;
                    break;
                }
            }
            int index = ultimaPosicion();
            if (index != -1) {
                listaEstudiantes[index] = newEstudiante;
            }
            return flag;
        }

        public Boolean eliminarEstudiante(Estudiante borrarEstudiante){
            boolean flag = false;
            for (int i = 0; i < listaEstudiantes.length; i++) {
                if (listaEstudiantes[i] != null && listaEstudiantes[i].getIdentificacion().equals(borrarEstudiante.getIdentificacion())){
                    listaEstudiantes[i] = null;
                    flag = true;
                    break;
                }
            }return flag;
        }

        public int mostrarEstudiante(Estudiante mostrarEstudiante){
            for (int i = 0; i < listaEstudiantes.length; i++) {
                if (listaEstudiantes[i] != null && listaEstudiantes[i].getIdentificacion().equals(mostrarEstudiante.getIdentificacion())){
                    return i;
                }
            }return -1;
        }

        public void editarEstudiante(Estudiante editarEstudiante){
            for (int i = 0; i < listaEstudiantes.length; i++) {
                if (listaEstudiantes[i] != null && listaEstudiantes[i].getIdentificacion().equals(editarEstudiante.getIdentificacion())){
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nombre a actualizar");
                    int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad actual"));
                    String nuevoGenero = JOptionPane.showInputDialog("Ingrese el genero actual");
                    String nuevasAlergias = JOptionPane.showInputDialog("Ingrese si tiene nuevas alergias");
                    String actualNombreAcudiente = JOptionPane.showInputDialog("Ingrese el nombre del actual acudiente");
                    String actualNumAcudiente = JOptionPane.showInputDialog("Ingrese el numero de contacto del actual acudiente");

                    editarEstudiante.setNombre(nuevoNombre);
                    editarEstudiante.setEdad(nuevaEdad);
                    editarEstudiante.setGenero(nuevoGenero);
                    editarEstudiante.setAlergias(nuevasAlergias);
                    editarEstudiante.setNombreAcudiente(actualNombreAcudiente);
                    editarEstudiante.setNumAcudiente(actualNumAcudiente);
                    break;
                }
            }
        }

        public ArrayList<Estudiante> estudiantesMayores(){
            ArrayList<Estudiante> mayores = new ArrayList<>();
            for (int i = 0; i < listaEstudiantes.length; i++) {
                if (listaEstudiantes[i] != null && listaEstudiantes[i].getEdad() >= edadMinima) {
                    mayores.add(listaEstudiantes[i]);
                }
            }return mayores;
        }

        public int edadNVeces(){
            int contador = 0;
            for (int i = 0; i < listaEstudiantes.length; i++) {
                if (listaEstudiantes[i] != null && listaEstudiantes[i].getEdad() == edadBuscar) {
                    contador += 1;
                }
            }return contador;
        }

        public int edadRepetida(){
            HashMap<Integer, Integer> frecuenciaEdades = new HashMap<>();
            int edadMasRepetida = -1;
            int maxFrecuencia = 0;
            for (Estudiante estudiante : listaEstudiantes) {
                if (estudiante != null) {
                    int edad = estudiante.getEdad();
                    frecuenciaEdades.put(edad, frecuenciaEdades.getOrDefault(edad, 0) + 1);

                    if (frecuenciaEdades.get(edad) > maxFrecuencia) {
                        maxFrecuencia = frecuenciaEdades.get(edad);
                        edadMasRepetida = edad;
                    }
                }
            }return edadMasRepetida;
        }

        public String nombreLargo(){
            String nombreMasLargo = "";
            for (Estudiante estudiante : listaEstudiantes) {
                if (estudiante != null && estudiante.getNombre().length() > nombreMasLargo.length()) {
                    nombreMasLargo = estudiante.getNombre();
                }
            }return nombreMasLargo;
        }

        public ArrayList<Estudiante> listEstudiantesConXCaracter(){
            ArrayList<Estudiante> estudiantes = new ArrayList<>();
            char letraNombre;
            for (Estudiante estudiante : listaEstudiantes) {
                nombre = estudiante.getNombre();
                letraNombre = nombre.charAt(0);
                if (estudiante != null && letraNombre == caracter) {
                    estudiantes.add(estudiante);
                }
            }return estudiantes;
        }

    //Constructor
    public Guarderia(String nombre, String nit, int cantidadEstudiantes, int edadMinima, int edadBuscar, char caracter) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaEstudiantes = new Estudiante[cantidadEstudiantes];
        this.edadMinima = edadMinima;
        this.edadBuscar = edadBuscar;
        this.caracter = caracter;

    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadBuscar() {
        return edadBuscar;
    }

    public void setEdadBuscar(int edadBuscar) {
        this.edadBuscar = edadBuscar;
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

    public Estudiante[] getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Estudiante[] listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}