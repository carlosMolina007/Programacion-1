package co.edu.uniquindio;

public class Batallon {

    //Atributos
    private String nombre;
    private String nit;
    private Vehiculo[] listVehiculos = new Vehiculo[30];
    private Mision[] listMisiones = new Mision[100];

    //Constructor
    public Batallon(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    //Metodos

    //Metodo que verifica si un vehiculo ya está registrado con una ID
    public int verificarID(Vehiculo idVehiculo) {
        for (int i = 0; i < listVehiculos.length; i++) {
            if (listVehiculos[i] != null && idVehiculo.getId().equals(listVehiculos[i].getId())) {
                return i;
            }
        }return -1;
    }

    //Verifica si se puede crear un nuevo vehiculo
    public boolean crearVehiculo(Vehiculo newVehiculo) {
        int index = verificarID(newVehiculo);
        for (int i = 0; i < listVehiculos.length; i++) {
            if (listVehiculos[i] == null && index == -1) {
                listVehiculos[i] = newVehiculo;
                return true;
            }
        }return false;
    }

    //Elimina el vehiculo que se verifica anteriormente en el otro metodo
    public boolean eliminarVehiculo(Vehiculo idVehiculo) {
        int index = verificarID(idVehiculo);
        if (index != -1) {
            listVehiculos[index] = null;
            return true;
        }return false;
    }

    //Retorna el arreglo/lista de vehiculos
    public Vehiculo[] listVehiculos() {
        return listVehiculos;
    }

    //Verifica el ID del vehiculo y permite modificarlo
    public boolean modificarVehiculo(Vehiculo modificarVehiculo) {
        int index = verificarID(modificarVehiculo);
        if (index != -1) {
            listVehiculos[index] = modificarVehiculo;
            return true;
        }return false;
    }

    //Metodo que registra una nueva misión
    public Mision[] agregarMision(Mision nuevaMision) {
        for (int i = 0; i < listMisiones.length; i++) {
            if (listMisiones[i] == null) {
                listMisiones[i] = nuevaMision;
            }
        }return listMisiones;
    }

    //Metodo que retorna arreglo con los vehiculos con más de 50 misiones
    public Vehiculo[] vehiculos50misiones(){
        int longArreglo = 0;
        //recorremos el arreglo para definir el tamaño del arreglo que vamos a retornar
        for (int i = 0; i < listVehiculos.length; i++) {
            if (listVehiculos[i] != null && listVehiculos[i].getCantMisiones() > 50) {
                longArreglo++;
            }
        }
        //Verificamos que vehiculos tienen más de 50 misiones y los agregamos al arreglo que retornaremos
        Vehiculo[] vehiculos50Misiones = new Vehiculo[longArreglo];
        for (int i = 0; i < listVehiculos.length; i++) {
            if (listVehiculos[i] != null && listVehiculos[i].getCantMisiones() > 50) {
                vehiculos50Misiones[i] = listVehiculos[i];
            }
        }return vehiculos50Misiones;
    }



    //Getter's and setter's
    public String getNombre(){
        return nombre;
    }
    public String getNit(){
        return nit;
    }
    public void setNit(String nit){
        this.nit = nit;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
