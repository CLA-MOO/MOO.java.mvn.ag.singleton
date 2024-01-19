/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package miPrincipal;

import geometric.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test public void testCircle() {
        CalculadoraGeometrica cg = CalculadoraGCirculos.getInstance();

        assertTrue(cg.calcularArea(7, 0)==3.1416 * 7 * 7);
        assertTrue(cg.calcularPerimetro(7, 0) == 2 * 3.1416 * 7);
    }

    @Test public void testElipse() {
        CalculadoraGeometrica cg = CalculadoraGElipse.getInstance();

        assertTrue(cg.calcularArea(7, 2)==3.1416 * 7 * 2);
        assertTrue(cg.calcularPerimetro(7, 2) == 2 * 3.1416 * Math.sqrt((7*7 + 2*2)/2));
    }

    @Test public void testCuadrado() {
        CalculadoraGeometrica cg = CalculadoraGCuadrado.getInstance();

        assertTrue(cg.calcularArea(7, 0)==7 * 7);
        assertTrue(cg.calcularPerimetro(7, 0) == 7 * 4);
    }

    @Test public void testRectangulo() {
        CalculadoraGeometrica cg = CalculadoraGRectangulo.getInstance();

        assertTrue(cg.calcularArea(7, 2) == 7 * 2);
        assertTrue(cg.calcularPerimetro(7, 2) == 2 * (7 + 2));
    }
}
