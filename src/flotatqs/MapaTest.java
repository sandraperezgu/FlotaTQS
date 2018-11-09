package flotatqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MapaTest {

	@Test
	void testCaracterAnumerico() {
		
		Mapa mapa = new Mapa();
		
		int posicion = 0;
		posicion = mapa.caracterAnumerico('A');
		assertEquals(posicion, 0);		
		posicion = mapa.caracterAnumerico('B');
		assertEquals(posicion, 1);
		posicion = mapa.caracterAnumerico('G');
		assertEquals(posicion, 6);
		posicion = mapa.caracterAnumerico('H');
		assertEquals(posicion, 7);

	}
	
	@Test
	void testGenerarMapaVacio() {
		Mapa mapa = new Mapa();
		
		mapa.generarMapaVacio();
		// Obtengo el tablero creado para comprobar si no hay ningun barco en el mapa
		Casilla[][] tablero = mapa.getTablero();
		
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero.length; j++)
				assertFalse(tablero[i][j].isBarco());
		}
	}

	@Test
	void testAnadirBarco() {
		
		Mapa mapa = new Mapa();
		MockTablero tablero = new MockTablero();
		mapa.setTablero(tablero);
		
		// LANCHAS
		boolean barcoColocado = mapa.anadirBarco(new Barco(1), 'G', 2, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'F', 4, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'C', 3, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'D', 6, 0);
		assertFalse(barcoColocado);
		
		barcoColocado = mapa.anadirBarco(new Barco(1), 'D', 2, 0);
		assertTrue(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'A', 1, 0);
		assertTrue(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'H', 8, 0);
		assertTrue(barcoColocado);
		
		
	}
	
	@Test
	void testBarcosAlrededor() {
		Mapa mapa = new Mapa();
		MockTablero tablero = new MockTablero();
		mapa.setTablero(tablero);
		
		// LANCHAS
		boolean barcoColocado = mapa.anadirBarco(new Barco(1), 'C', 2, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'D', 7, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'E', 4, 0);
		assertFalse(barcoColocado);	
		barcoColocado = mapa.anadirBarco(new Barco(1), 'H', 2, 0);
		assertFalse(barcoColocado);
		
		barcoColocado = mapa.anadirBarco(new Barco(1), 'B', 5, 0);
		assertTrue(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'A', 1, 0);
		assertTrue(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'H', 8, 0);
		assertTrue(barcoColocado);
	}
}
