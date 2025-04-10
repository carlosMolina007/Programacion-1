import co.edu.uniquindio.AreaEspecializacion;
import co.edu.uniquindio.Batallon;
import co.edu.uniquindio.RangoMilitar;
import co.edu.uniquindio.Soldado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;



class testBatallon {

    private static final Logger LOG = Logger.getLogger(testBatallon.class.getName());

    @Test
    void testBatallon() {
        LOG.info("Test batallon");
    }


    @Test
    @DisplayName("Prueba metodo disponibilidad de un soldado por especialidad")
    void testDisponibilidad() {
        LOG.info("inicio test disponibilidad de un soldado por especialidad");
        Batallon batallon = new Batallon("AltaMontña", "10099");
        Soldado soldado01 = new Soldado("0001", "Pepe Khe1", RangoMilitar.CABO, AreaEspecializacion.MEDICO, 20, true);
        Soldado soldado02 = new Soldado("0002", "Pepe Khe2", RangoMilitar.CABO, AreaEspecializacion.COMUNICACIONES, 20, false);
        Soldado soldado03 = new Soldado("0003", "Pepe Khe3", RangoMilitar.CABO, AreaEspecializacion.LOGISITCA, 20, true);
        new LinkedList<Soldado>();
        soldadosTest.add(soldado01,soldado02, soldado03);
        assertTrue(batallon.buscarSoldadosDisponibles());
    }




    @Test
    @DisplayName("prueba del metodo edad promedio")
    void testEdadPromedio(){
        LOG.info("inicio de prueba Edad Promedio");
        Batallon batallon = new Batallon("Nombre", "id");
        Soldado soldado1 = new Soldado("id1", "nombre apellido1", RangoMilitar.SOLDADO, AreaEspecializacion.COMUNICACIONES, 15, false);
        Soldado soldado2 = new Soldado("id2", "nombre apellido2", RangoMilitar.CABO, AreaEspecializacion.MEDICO, 18, false);
        Soldado soldado3 = new Soldado("id3", "nombre apellido3", RangoMilitar.SARGENTO, AreaEspecializacion.LOGISITCA, 86, false);
        double promedio = (double) (soldado1.getEdad() + soldado2.getEdad() + soldado3.getEdad()) / 3;
        batallon.soldados.add(soldado1);
        batallon.soldados.add(soldado2);
        batallon.soldados.add(soldado3);
        assertEquals(promedio == batallon.calcularEdadPromedio());
        LOG.info("fin de prueba edad promedio");
    }

    @Test
    @DisplayName("prueba del metodo edad promedio")
    void testEdadPromedio(){}













}
