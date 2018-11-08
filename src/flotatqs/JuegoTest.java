package flotatqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JuegoTest {

	@Test
	void testComprobarPosicionCursor() {
		Juego juego = new Juego();

		boolean posicion = juego.comprobarPosicionCursor("A1");
		assertTrue(posicion);
		posicion = juego.comprobarPosicionCursor("A-1");
		assertFalse(posicion);
		posicion = juego.comprobarPosicionCursor("A2");
		assertTrue(posicion);
		posicion = juego.comprobarPosicionCursor("A7");
		assertTrue(posicion);
		posicion = juego.comprobarPosicionCursor("A8");
		assertTrue(posicion);
		posicion = juego.comprobarPosicionCursor("A9");
		assertFalse(posicion);
		
		posicion = juego.comprobarPosicionCursor("55");
		assertFalse(posicion);
		posicion = juego.comprobarPosicionCursor("AA");
		assertFalse(posicion);
		posicion = juego.comprobarPosicionCursor("A");
		assertFalse(posicion);
		posicion = juego.comprobarPosicionCursor("9");
		assertFalse(posicion);
		
		posicion = juego.comprobarPosicionCursor("B1");
		assertTrue(posicion);
		posicion = juego.comprobarPosicionCursor("G1");
		assertTrue(posicion);
		posicion = juego.comprobarPosicionCursor("H1");
		assertTrue(posicion);
		posicion = juego.comprobarPosicionCursor("I1");
		assertFalse(posicion);
		posicion = juego.comprobarPosicionCursor("Z1");
		assertFalse(posicion);
		
		posicion = juego.comprobarPosicionCursor("1A");
		assertFalse(posicion);
	
	}
	
	@Test
	void testPedirPosicion() {
		// Recoge el String que introduce el usuario, independientemente de que sea correcto o no
		Juego juego = new Juego();
		MockTeclado teclado = new MockTeclado();
		juego.setTeclado(teclado);
		
		String posicion = juego.pedirPosicion(5);
		assertEquals(posicion, "A1");
		posicion = juego.pedirPosicion(3);
		assertEquals(posicion, "B2");
		posicion = juego.pedirPosicion(1);
		assertEquals(posicion, "H1");
		posicion = juego.pedirPosicion(5);
		assertEquals(posicion, "Z1");
	}
	
	@Test
	void testPedirDireccion() {
		// Recoge el numero que introduce el usuario, independientemente de que sea correcto o no
		Juego juego = new Juego();
		MockTeclado teclado = new MockTeclado();
		juego.setTeclado(teclado);
		
		int direccion = juego.pedirDireccion();
		assertEquals(direccion, 2);
		direccion = juego.pedirDireccion();
		assertEquals(direccion, 2);
		direccion = juego.pedirDireccion();
		assertEquals(direccion, 0);
		direccion = juego.pedirDireccion();
		assertEquals(direccion, 2);

	}
}
