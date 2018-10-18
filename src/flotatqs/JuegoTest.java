package flotatqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JuegoTest {

	@Test
	void testObtenerPosicionCursor() {
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
		assertTrue(posicion);
		posicion = juego.comprobarPosicionCursor("Z1");
		assertFalse(posicion);
		
		posicion = juego.comprobarPosicionCursor("1A");
		assertFalse(posicion);
	


		
		 
	}

}
