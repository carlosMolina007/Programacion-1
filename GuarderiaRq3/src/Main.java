import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int cantidadEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes que quiere agregar"));
        int edadMinima = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una edad para buscar estudiantes mayores a la ingresada"));
        int edadBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una edad para buscar estudiantes con esta misma edad"));
        char letra = JOptionPane.showInputDialog("Ingrese una letra para buscar nombres que empiecen con esta").charAt(0);
        Guarderia guarderia = new Guarderia("Pequeños Gigantes", "1.900.234.211.98", cantidadEstudiantes,
                edadMinima, edadBuscar, letra);


        //Estudiantes predefinidos
        //guarderia.agregarEstudiante(new Estudiante("Juan Perez", 5, "Masculino", "1", "Ninguna", "Maria Perez", "1234567890"));
        //guarderia.agregarEstudiante(new Estudiante("Ana López", 4, "Femenino", "2", "Polen", "Carlos López", "0987654321"));
        //guarderia.agregarEstudiante(new Estudiante("Luis Martínez", 6, "Masculino", "3", "Gluten", "Sofia Martínez", "1122334455"));
        //guarderia.agregarEstudiante(new Estudiante("Elena Ruiz", 3, "Femenino", "4", "Ninguna", "Pedro Ruiz", "2233445566"));
        //guarderia.agregarEstudiante(new Estudiante("Diego Fernández", 5, "Masculino", "5", "Lactosa", "Laura Fernández", "3344556677"));
        while(true) {
            int option = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al colegio " + guarderia.getNombre() +
                    "\nDigite en pantalla el número de alguna de las siguientes opciones\n " +
                    "1. Agregar estudiante\n" +
                    "2. Editar estudiante\n" +
                    "3. Eliminar estudiante\n" +
                    "4. Obtener estudiante\n" +
                    "5. Obtener estudiantes mayores a un número que usted ingrese\n" +
                    "6. Cuantas veces se repite una edad\n" +
                    "7. Obtener la edad más repetida\n" +
                    "8. Obtener el nombre más largo\n" +
                    "9. Obtener lista de nombres que empiecen por una letra ingresada\n" +
                    "0. Salir"));

            if (option == 1) {
                for (int i = 0; i < cantidadEstudiantes; i++) {
                    JOptionPane.showMessageDialog(null, "A continuación ingresará los datos del estudiante " + (i + 1));
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante"));
                    String genero = JOptionPane.showInputDialog("Ingrese el genero del estudiante");
                    String identificacion = JOptionPane.showInputDialog("Ingrese el ID del estudiante");
                    String alergias = JOptionPane.showInputDialog("Ingrese si tiene alguna alergia");
                    String nombreAcudiente = JOptionPane.showInputDialog("Ingrese el nombre del acudiente");
                    String celAcudiente = JOptionPane.showInputDialog("Ingrese el número telefónico del acudiente");

                    Estudiante estudiante = new Estudiante(nombre, edad, genero, identificacion,
                            alergias, nombreAcudiente, celAcudiente);
                    guarderia.agregarEstudiante(estudiante);
                }JOptionPane.showMessageDialog(null, "Estudiantes agregados correctamente");
            } else if (option == 2) {
                String id = JOptionPane.showInputDialog("Ingrese el id del estudiante que desea actualizar");

                for (Estudiante editarEstudiante : guarderia.getListaEstudiantes()) {
                    if (editarEstudiante.getIdentificacion().equals(id)) {
                        guarderia.editarEstudiante(editarEstudiante);
                        JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente");
                        break;

                    }else{
                        JOptionPane.showMessageDialog(null, "Estudiante inexistente");
                    }
                }
            } else if (option == 3) {
                String id = JOptionPane.showInputDialog("Ingrese el id del estudiante que desea eliminar");
                boolean existeEstudiante = false;

                for (Estudiante estudianteEliminar : guarderia.getListaEstudiantes()) {
                    if (estudianteEliminar != null && estudianteEliminar.getIdentificacion().equals(id)) {
                        boolean eliminado = guarderia.eliminarEstudiante(estudianteEliminar);

                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar el estudiante.");
                        }

                        existeEstudiante = true;
                        break;
                    }
                }

                if (!existeEstudiante) {
                    JOptionPane.showMessageDialog(null, "Estudiante inexistente.");
                }
            }else if (option == 4) {
                String id = JOptionPane.showInputDialog("Ingrese el id del estudiante que desea obtener");

                for (Estudiante estudianteMostrar : guarderia.getListaEstudiantes()){
                    if (estudianteMostrar != null && estudianteMostrar.getIdentificacion().equals(id)){
                        int indexEstudiante = guarderia.mostrarEstudiante(estudianteMostrar);

                        if(indexEstudiante != -1){
                            JOptionPane.showMessageDialog(null, estudianteMostrar);
                        }else{
                            JOptionPane.showMessageDialog(null, "Estudiante inexistente");
                        }
                        break;
                    }if(guarderia.mostrarEstudiante(estudianteMostrar) == -1){
                        JOptionPane.showMessageDialog(null, "Estudiante inexistente");
                    }
                }
            } else if (option == 5) {

                ArrayList<Integer> mayores = new ArrayList<>();
                for (Estudiante estudiante : guarderia.estudiantesMayores()) {
                    mayores.add(estudiante.getEdad());
                }
                JOptionPane.showMessageDialog(null, "Las edades mayores a "+edadMinima+" años son:\n "+mayores );


            }else if (option == 6) {
                int edadNRepeticiones = guarderia.edadNVeces();
                JOptionPane.showMessageDialog(null, "La edad "+edadBuscar+ " se repite "+edadNRepeticiones+" veces");
            }else if (option == 7) {
                int edadMasRepetida = guarderia.edadRepetida();
                JOptionPane.showMessageDialog(null, "La edad más repetida es "+edadMasRepetida);
            }else if (option == 8) {
                String nombreMasLargo = guarderia.nombreLargo();
                JOptionPane.showMessageDialog(null, "El nombre más largo pertenece a "+nombreMasLargo);
            }else if (option == 9) {
                ArrayList<String> nombresConXLetra = new ArrayList<>();
                for (Estudiante estudiante : guarderia.listEstudiantesConXCaracter()) {
                    nombresConXLetra.add(estudiante.getNombre());
                }
                JOptionPane.showMessageDialog(null, "Estudiantes cuyos nombres empiezan por la letra "+letra+" son:\n "+nombresConXLetra );
            }else if (option == 0) {
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Opción incorrecta, intente nuevamente");
            }

        }

        }
    }