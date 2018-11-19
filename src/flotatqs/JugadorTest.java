package flotatqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JugadorTest {
	// comprueba si el barco se puede hundir
	@Test
	void testIsBarcoHundido() {
		MockPerfil mp = new MockPerfil();
		Jugador jugador = new Jugador();
		jugador.setPerfilJugador(mp);
		jugador.crearMapa();
		
		boolean elBarcoSeHunde = jugador.isBarcoHundido('A', 1);
		assertTrue(elBarcoSeHunde);
		elBarcoSeHunde = jugador.isBarcoHundido('D', 4);
		assertTrue(elBarcoSeHunde);
		elBarcoSeHunde = jugador.isBarcoHundido('D', 6);
		assertTrue(elBarcoSeHunde);
		elBarcoSeHunde = jugador.isBarcoHundido('D', 8);
		assertTrue(elBarcoSeHunde);
	
		elBarcoSeHunde = jugador.isBarcoHundido('B', 7);
		assertTrue(elBarcoSeHunde);
		
		elBarcoSeHunde = jugador.isBarcoHundido('H', 1);
		assertFalse(elBarcoSeHunde);
		elBarcoSeHunde = jugador.isBarcoHundido('H', 3);
		assertFalse(elBarcoSeHunde);
		//Barco con una sola posición donde el barco está en pie
		elBarcoSeHunde = jugador.isBarcoHundido('E', 1);
		assertFalse(elBarcoSeHunde);
		
		elBarcoSeHunde = jugador.isBarcoHundido('F', 3);
		assertFalse(elBarcoSeHunde);
		
	}

}
