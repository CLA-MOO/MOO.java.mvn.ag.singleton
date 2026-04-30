package miPrincipal;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para validar el patrón Singleton en MonitorDeLineaDeProduccion.
 */
public class AppTest
{
    /**
     * Reinicia la instancia Singleton antes de cada prueba para aislarlas.
     */
    @Before
    public void reiniciarInstancia() throws Exception {
        Field campo = MonitorDeLineaDeProduccion.class.getDeclaredField("instancia");
        campo.setAccessible(true);
        campo.set(null, null);
    }

    /**
     * Verifica que dos llamadas a getInstancia() devuelven el mismo objeto.
     */
    @Test
    public void testInstanciaUnica() {
        MonitorDeLineaDeProduccion m1 = MonitorDeLineaDeProduccion.getInstancia();
        MonitorDeLineaDeProduccion m2 = MonitorDeLineaDeProduccion.getInstancia();
        assertSame("Ambas referencias deben apuntar a la misma instancia", m1, m2);
    }

    /**
     * Verifica que el estado de la línea es compartido entre las dos referencias.
     */
    @Test
    public void testEstadoCompartido() {
        MonitorDeLineaDeProduccion m1 = MonitorDeLineaDeProduccion.getInstancia();
        MonitorDeLineaDeProduccion m2 = MonitorDeLineaDeProduccion.getInstancia();
        m1.iniciarLinea();
        assertTrue("El estado de la línea debe ser compartido entre referencias", m2.isLineaActiva());
    }

    /**
     * Verifica que el contador de vehículos es compartido entre referencias.
     */
    @Test
    public void testContadorVehiculosCompartido() {
        MonitorDeLineaDeProduccion m1 = MonitorDeLineaDeProduccion.getInstancia();
        m1.iniciarLinea();
        m1.registrarVehiculo("Sedán XR-5");
        m1.registrarVehiculo("SUV Trail-3");
        MonitorDeLineaDeProduccion m2 = MonitorDeLineaDeProduccion.getInstancia();
        assertEquals("El contador de vehículos debe ser compartido", 2, m2.getVehiculosEnsamblados());
    }

    /**
     * Verifica que el constructor es privado (no accesible desde fuera).
     */
    @Test
    public void testConstructorPrivado() throws Exception {
        Constructor<MonitorDeLineaDeProduccion> constructor =
                MonitorDeLineaDeProduccion.class.getDeclaredConstructor();
        assertFalse("El constructor debe ser privado",
                Modifier.isPublic(constructor.getModifiers()));
    }

    /**
     * Verifica el comportamiento al intentar registrar un vehículo con la línea detenida.
     */
    @Test
    public void testRegistroConLineaDetenida() {
        MonitorDeLineaDeProduccion m1 = MonitorDeLineaDeProduccion.getInstancia();
        String resultado = m1.registrarVehiculo("Pickup TMax");
        assertEquals("Error: la linea esta detenida, no se puede registrar el vehiculo.", resultado);
        assertEquals("El contador de vehículos no debe incrementarse cuando la linea esta detenida.",
                0, m1.getVehiculosEnsamblados());
    }

    /**
     * Verifica que detener la línea cambia el estado correctamente.
     */
    @Test
    public void testDetenerLinea() {
        MonitorDeLineaDeProduccion m1 = MonitorDeLineaDeProduccion.getInstancia();
        m1.iniciarLinea();
        m1.detenerLinea();
        assertFalse("Después de detener la línea, isLineaActiva debe ser false", m1.isLineaActiva());
    }

    /**
     * Verifica que el contador de defectos es compartido entre referencias.
     */
    @Test
    public void testContadorDefectosCompartido() {
        MonitorDeLineaDeProduccion m1 = MonitorDeLineaDeProduccion.getInstancia();
        MonitorDeLineaDeProduccion m2 = MonitorDeLineaDeProduccion.getInstancia();
        m1.iniciarLinea();
        m1.registrarDefecto("Puerta mal alineada");
        m1.registrarDefecto("Faro defectuoso");
        assertEquals("El contador de defectos debe ser compartido entre referencias", 2, m2.getDefectosDetectados());
    }
}
