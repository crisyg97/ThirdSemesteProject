package prog2TPC1_2018;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDefaultTp {

	private Habitacion h1, h2, h3;
	@Before
	public void setUp() {
		h1 = new Habitacion(10,20); // habitacion de 10x20
		h1.agregarCaja(3, 3, 4); // caja de 3x3 con el elemento 4
		h1.agregarCaja(3, 4, 4); // el elemento se puede repetir
		h1.agregarCaja(3, 5, 4);
		h2 = new Habitacion(20,15);
		h2.agregarCaja(3, 3, 4);
		h3 = new Habitacion(10,20);
		h3.agregarCaja(3, 3, 4);
		h3.agregarCaja(3, 4, 4);
		h3.agregarCaja(3, 5, 4);
	}
	@Test
	public void testHabitacion() {
	//h1 tiene que ser igual que h3 y distinto que h2
		assertTrue(h1.equals(h3));
		assertTrue(!h1.equals(h2));
	}
	@Test
	public void testPuedoAgregarCaja() {
	// no puedo agregar cualquier caja
		assertTrue(!(h1.puedoAgregarCaja(100, 10)));
	}
	@Test
	public void testAgregarCaja() {
		int cant = h1.cantCajas();
		h1.agregarCaja(1, 1, 2);
	// cambio la cantidad de cajas
		assertTrue(h1.cantCajas() != cant);
	}
	@Test
	public void testReacomodarCajas() {
		int cant = h3.cantCajas();
	//intentan reacomodar y devuelve la cantidad de cajas que pudo reacomodar
		int aux = h3.reacomodarCajas();
	//reacomodar no pierde cajas
		assertTrue(h1.cantCajas()== cant);
	}
	@Test
	public void testImprimir(){
		h1.imprimirHabitacion();
		h2.imprimirHabitacion();
	}
}
