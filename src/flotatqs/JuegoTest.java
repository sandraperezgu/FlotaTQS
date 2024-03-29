package flotatqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JuegoTest {

	// comprueba que el dato introducido sea correcto
	// limites y particiones equivalentes del tablero
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

	// Comprueba limites del tablero
	@Test
	void testComprobarLimitesTablero() {
		Juego juego = new Juego();
		// Parámetros: int direccion, char fila, int columna, int longitudBarco
		// 1 - Vertical hacia arriba
		// 2 - Vertical hacia abajo
		// 3 - Horizontal derecha
		// 4 - Horizontal izquierda
		
		// BUQUES
		
		// Vertical hacia arriba primera fila sobresaliendo 2
		boolean valido = juego.comprobarLimitesTablero(1, 'A', 1, 3);
		assertFalse(valido);
		// Vertical hacia arriba esquinas superiores sobresaliendo 1
		valido = juego.comprobarLimitesTablero(1, 'B', 2, 3);
		assertFalse(valido);
		// Vertical hacia arriba esquinas superiores sin sobresalir
		valido = juego.comprobarLimitesTablero(1, 'C', 3, 3);
		assertTrue(valido);

		// Vertical hacia abajo ultima fila sobresaliendo 2
		valido = juego.comprobarLimitesTablero(2, 'H', 4, 3);
		assertFalse(valido);
		// Vertical hacia abajoultima fila sobresaliendo 1
		valido = juego.comprobarLimitesTablero(2, 'G', 5, 3);
		assertFalse(valido);
		// Vertical hacia abajo ultima fila sin sobresalir
		valido = juego.comprobarLimitesTablero(2, 'F', 6, 3);
		assertTrue(valido);

		// Horizontal- derecha. ultima columnna sobresaliendo 2
		valido = juego.comprobarLimitesTablero(3, 'A', 8, 3);
		assertFalse(valido);
		// Horizontal- derecha. ultima columnna sobresaliendo 1
		valido = juego.comprobarLimitesTablero(3, 'C', 7, 3);
		assertFalse(valido);
		// Horizontal- derecha. ultima columnna sin sobresalir
		valido = juego.comprobarLimitesTablero(3, 'E', 6, 3);
		assertTrue(valido);
		
		// Horizontal- izquierda. primera columnna sobresaliendo 2
		valido = juego.comprobarLimitesTablero(4, 'B', 1, 3);
		assertFalse(valido);
		// Horizontal- izquierda. primera columnna sobresaliendo 1
		valido = juego.comprobarLimitesTablero(4, 'A', 2, 3);
		assertFalse(valido);
		// Horizontal- izquierda. primera columnna sin sobresalir
		valido = juego.comprobarLimitesTablero(4, 'C', 3, 3);
		assertTrue(valido);
		
		// PORTAAVIONES
		
		// Vertical hacia arriba primera fila sobresaliendo 4
		valido = juego.comprobarLimitesTablero(1, 'A', 1, 5);
		assertFalse(valido);
		// Vertical hacia arriba primera fila sobresaliendo 3
		valido = juego.comprobarLimitesTablero(1, 'B', 2, 5);
		assertFalse(valido);
		// Vertical hacia arriba primera fila sobresaliendo 2
		valido = juego.comprobarLimitesTablero(1, 'C', 3, 5);
		assertFalse(valido);
		// Vertical hacia arriba primera fila sobresaliendo 1
		valido = juego.comprobarLimitesTablero(1, 'D', 4, 5);
		assertFalse(valido);
		// Vertical hacia arriba primera fila sin sobresalir
		valido = juego.comprobarLimitesTablero(1, 'E', 5, 5);
		assertTrue(valido);

		// Vertical hacia arriba ultima fila sobresaliendo 4
		valido = juego.comprobarLimitesTablero(2, 'H', 6, 5);
		assertFalse(valido);
		// Vertical hacia arriba ultima fila sobresaliendo 3
		valido = juego.comprobarLimitesTablero(2, 'G', 7, 5);
		assertFalse(valido);
		// Vertical hacia arriba ultima fila sobresaliendo 2
		valido = juego.comprobarLimitesTablero(2, 'F', 8, 5);
		assertFalse(valido);
		// Vertical hacia arriba ultima fila sobresaliendo 1
		valido = juego.comprobarLimitesTablero(2, 'E', 1, 5);
		assertFalse(valido);
		// Vertical hacia arriba ultima fila sin sobresalir
		valido = juego.comprobarLimitesTablero(2, 'D', 2, 5);
		assertTrue(valido);
		
		// Horizontal- derecha. ultima columnna sobresaliendo 4
		valido = juego.comprobarLimitesTablero(3, 'A', 8, 5);
		assertFalse(valido);
		// Horizontal- derecha. ultima columnna sobresaliendo 3
		valido = juego.comprobarLimitesTablero(3, 'C', 7, 5);
		assertFalse(valido);
		// Horizontal- derecha. ultima columnna sobresaliendo 2
		valido = juego.comprobarLimitesTablero(3, 'D', 6, 5);
		assertFalse(valido);
		// Horizontal- derecha. ultima columnna sobresaliendo 1
		valido = juego.comprobarLimitesTablero(3, 'F', 5, 5);
		assertFalse(valido);
		// Horizontal- derecha. ultima columnna sin sobresalir
		valido = juego.comprobarLimitesTablero(3, 'H', 4, 5);
		assertTrue(valido);

		// Horizontal- izquierda. primera columnna sobresaliendo 4
		valido = juego.comprobarLimitesTablero(4, 'A', 1 , 5);
		assertFalse(valido);
		// Horizontal- izquierda. primera columnna sobresaliendo 3
		valido = juego.comprobarLimitesTablero(4, 'B', 2 , 5);
		assertFalse(valido);
		// Horizontal- izquierda. primera columnna sobresaliendo 2
		valido = juego.comprobarLimitesTablero(4, 'H', 3, 5);
		assertFalse(valido);
		// Horizontal- izquierda. primera columnna sobresaliendo 1
		valido = juego.comprobarLimitesTablero(4, 'G', 4, 5);
		assertFalse(valido);
		// Horizontal- izquierda. primera columnna sin sobresalir
		valido = juego.comprobarLimitesTablero(4, 'C', 5, 5);
		assertTrue(valido);

		// POR MEDIO DEL TABLERO
		valido = juego.comprobarLimitesTablero(2, 'B', 7, 3);
		assertTrue(valido);
		valido = juego.comprobarLimitesTablero(1, 'G', 7, 3);
		assertTrue(valido);
		valido = juego.comprobarLimitesTablero(3, 'C', 2, 3);
		assertTrue(valido);
		valido = juego.comprobarLimitesTablero(4, 'E', 7, 3);
		assertTrue(valido);
		valido = juego.comprobarLimitesTablero(1, 'F', 7, 5);
		assertTrue(valido);
		valido = juego.comprobarLimitesTablero(2, 'B', 7, 5);
		assertTrue(valido);
		valido = juego.comprobarLimitesTablero(3, 'G', 3, 5);
		assertTrue(valido);
		valido = juego.comprobarLimitesTablero(4, 'F', 6, 5);
		assertTrue(valido);
		// CUALQUIER OTRO
		valido = juego.comprobarLimitesTablero(5, 'C', 5, 5);
		assertFalse(valido);
		valido = juego.comprobarLimitesTablero(0, 'F', 4, 3);
		assertFalse(valido);
	}
	
	// Test que comprueba si la casilla ha sido tocada o no
	@Test
	void testCompararMapas() {
		Juego juego = new Juego();
		MockPartida mp = new MockPartida();
		MockTeclado mt = new MockTeclado();
		juego.setPartida(mp);
		juego.setTeclado(mt);
		
		juego.setJugador1();
		
		juego.setJugador2();
		
		juego.colocarBarcos(juego.getJugador1());
		//juego.getJugador2().crearMapa();
		juego.copiarMapaOponente(juego.getJugador1(), juego.getJugador2());
		juego.copiarMapaOponente(juego.getJugador2(), juego.getJugador1());
		
		boolean iguales = juego.compararMapas('A', 1);
		assertTrue(iguales);
		iguales = juego.compararMapas('G', 8);
		assertFalse(iguales);
		iguales = juego.compararMapas('D', 5);
		assertTrue(iguales);
		
	}
	
	/*@Test
	public void testComprobarGanador() {
		Juego juego = new Juego();
		MockPartida mp = new MockPartida();
		MockTeclado mt = new MockTeclado();
		juego.setPartida(mp);
		juego.setTeclado(mt);
		
		juego.setJugador1();
		
		juego.setJugador2();
		
		juego.colocarBarcos(juego.getJugador1());
		juego.getJugador2().crearMapa();
		juego.colocarBarcos(juego.getJugador2());
		juego.copiarMapaOponente(juego.getJugador1(), juego.getJugador2());
		juego.copiarMapaOponente(juego.getJugador2(), juego.getJugador1());
		
		int ganador = juego.comprobarGanador();
		assertEquals(ganador, 1);
	}*/
	
}
