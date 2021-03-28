package prog2TPC1_2018;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPersonalTp {

	private Habitacion hab1,hab2,hab3;
	
	@Before
	public void setUp(){
		hab1 = new Habitacion(10,20);
		hab1.agregarCaja(3, 5, 1);
		hab1.agregarCaja(4, 7, 2);
		hab1.agregarCaja(2, 2, 3);
		hab2 = new Habitacion(10,15);
		hab3 = new Habitacion(20,30);
	}
	
	@Test(expected = RuntimeException.class)
	public void Irep(){
		hab1.validarIrep();
	}
	
	@Test(expected = RuntimeException.class)
	public void testAgregarCajaGrande() {
		int cant = hab1.cantCajas();
		hab1.agregarCaja(20, 15, 2);
	// la cantidad de cajas no debe cambiar porque esa caja es demasiado grande
	// para agregarla
		assertTrue(hab1.cantCajas() == cant);
	}
}
