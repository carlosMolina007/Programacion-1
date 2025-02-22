import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Guarderia newGuarderia = new Guarderia("Pequeños Gigantes", "1-090-777-666");

        while(true) {
            int Option = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de alguna de " +
                    "las siguientes opciones:\n" +
                    "1. Agregar estudiante\n" +
                    "2. Editar estudiante\n" +
                    "3. Eliminar estudiante\n" +
                    "4. Obtener estudiante\n" +
                    "5. Obtener estudiantes mayores de 5 años\n" +
                    "6. Salir"));

            if (Option == 1) {
                int cantEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes que desea agregar"));
                for(int i = 1; i < cantEstudiantes+1; i++){
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del niño "+i);
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
                    String genero = JOptionPane.showInputDialog("Ingrese el genero");
                    String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion");
                    String alergias = JOptionPane.showInputDialog("Ingrese si tiene alergias");
                    String nombreAcudiente = JOptionPane.showInputDialog("Ingrese el nombre del acudiente");
                    String numAcudiente = JOptionPane.showInputDialog("Ingrese el numero de contacto del acudiente");

                    Estudiante newEstudiante = new Estudiante(nombre, edad, genero, identificacion, alergias,
                            nombreAcudiente, numAcudiente);
                    newGuarderia.agregarEstudiante(newEstudiante);
                }

            }else if(Option == 2) {
                String id = JOptionPane.showInputDialog("Ingrese el id del estudiante que desea actualizar");
                boolean existeEstudiante = false;

                for (Estudiante estudianteActualizar : newGuarderia.getListEstudiantes()){
                    if (estudianteActualizar.getIdentificacion().equals(id)){
                        newGuarderia.actualizarEstudiante(estudianteActualizar);
                        JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente");
                        existeEstudiante = true;
                        break;

                    }
                }if (!existeEstudiante){
                    JOptionPane.showMessageDialog(null, "Estudiante inexistente");
                }
            }else if (Option == 3) {
                String id = JOptionPane.showInputDialog("Ingrese el id del estudiante que desea eliminar");
                boolean existeEstudiante = false;

                for (Estudiante estudianteEliminar : newGuarderia.getListEstudiantes()){
                    if (estudianteEliminar.getIdentificacion().equals(id)){
                        newGuarderia.eliminarEstudiante(estudianteEliminar);
                        existeEstudiante = true;
                        break;
                    }
                }if (!existeEstudiante){
                    JOptionPane.showMessageDialog(null, "Estudiante inexistente");
                }
            }else if (Option == 4) {
                String id = JOptionPane.showInputDialog("Ingrese el id del estudiante que desea obtener");
                boolean existeEstudiante = false;

                for (Estudiante estudianteObtener : newGuarderia.getListEstudiantes()){
                    if (estudianteObtener.getIdentificacion().equals(id)){
                        newGuarderia.listarEstudiantes();
                        JOptionPane.showMessageDialog(null, estudianteObtener);
                        existeEstudiante = true;
                        break;
                    }
                }if (!existeEstudiante){
                    JOptionPane.showMessageDialog(null, "Estudiante inexistente");
                }
            }else if (Option == 5) {
                newGuarderia.estudiantesMayores5Anios();
                StringBuilder mensaje = new StringBuilder("Estudiantes mayores de 5 años:\n");

                for (Estudiante estudiante : newGuarderia.getEstudianteMayor5anios()) {
                    mensaje.append(estudiante.toString()).append("\n");
                } if (newGuarderia.getEstudianteMayor5anios().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay estudiantes mayores de 5 años.");
                } else {
                    JOptionPane.showMessageDialog(null, mensaje.toString());
                }
            }else if (Option == 6) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa");
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Opción incorrecta, intente nuevamente");
            }
        }
    }
}