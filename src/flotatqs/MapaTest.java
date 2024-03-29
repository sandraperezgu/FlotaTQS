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
		
		mapa.mapaVacio();
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
		mapa.mapaVacio();
		// LANCHAS
		boolean barcoColocado = mapa.anadirBarco(new Barco(1), 'G', 2, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'F', 4, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'C', 3, 0);
		assertFalse(barcoColocado);
		
		

		barcoColocado = mapa.anadirBarco(new Barco(1), 'A', 1, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(1), 'H', 8, 0);
		assertTrue(barcoColocado);
		
		// BUQUES Y PORTAVIONES
		barcoColocado = mapa.anadirBarco(new Barco(3), 'G', 2, 1);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(5), 'B', 5, 2);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(3), 'F', 1, 3);
		assertFalse(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(5), 'C', 8, 4);
		assertFalse(barcoColocado);
		
		barcoColocado = mapa.anadirBarco(new Barco(3), 'C', 5, 1);
		assertTrue(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(3), 'F', 6, 2);
		assertTrue(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(3), 'H', 1, 3);
		assertTrue(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(3), 'D', 4, 4);
		assertTrue(barcoColocado);
		barcoColocado = mapa.anadirBarco(new Barco(5), 'A', 8, 2);
		assertTrue(barcoColocado);
	}
	
	@Test
	void testBarcosAlrededor() {
		Mapa mapa = new Mapa();
		MockTablero tablero = new MockTablero();
		mapa.setTablero(tablero);
		mapa.mapaVacio();
		// LANCHAS
		boolean barcoColocado = mapa.barcosAlrededor(new Barco(1), 'C', 2, 0);
		assertTrue(barcoColocado);
		barcoColocado = mapa.barcosAlrededor(new Barco(1), 'D', 7, 0);
		assertFalse(barcoColocado);
		barcoColocado = mapa.barcosAlrededor(new Barco(1), 'E', 4, 0);
		assertFalse(barcoColocado);	

		
		barcoColocado = mapa.barcosAlrededor(new Barco(1), 'B', 5, 0);
		assertTrue(barcoColocado);
		//Limites tablero
		barcoColocado = mapa.barcosAlrededor(new Barco(1), 'A', 1, 0);
		assertTrue(barcoColocado);
		barcoColocado = mapa.barcosAlrededor(new Barco(1), 'H', 8, 0);
		assertTrue(barcoColocado);
		
		// Vertical hacia arriba
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'E', 7, 1);
		assertFalse(barcoColocado);
		barcoColocado = mapa.barcosAlrededor(new Barco(5), 'E', 2, 1);
		assertFalse(barcoColocado);
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'G', 6, 1);
		assertFalse(barcoColocado);
		
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'C', 8, 1);
		assertTrue(barcoColocado);
		
		// Vertical hacia abajo
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'A', 8, 2);
		assertTrue(barcoColocado);
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'E', 3, 2);
		assertFalse(barcoColocado);
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'C', 6, 2);
		assertFalse(barcoColocado);
		// Horizontal hacia la derecha
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'G', 5, 3);
		assertTrue(barcoColocado);

		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'B', 2, 3);
		assertFalse(barcoColocado);	
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'D', 5, 3);
		assertFalse(barcoColocado);	
		// Horizontal hacia la  izquierda
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'G', 7, 4);
		assertTrue(barcoColocado);

		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'B', 4, 4);
		assertFalse(barcoColocado);	
		barcoColocado = mapa.barcosAlrededor(new Barco(3), 'D', 8, 4);
		assertFalse(barcoColocado);
		
	}
	
	@Test
	void testcomprobarLimiteTablero() {
		
		Mapa mapa = new Mapa();
		MockTablero tablero = new MockTablero();
		mapa.setTablero(tablero);
		mapa.mapaVacio();
		boolean barcoColocado = mapa.comprobarLimiteTablero(0,1);
		assertTrue(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(7,1);
		assertTrue(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(0,8);
		assertTrue(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(7,8);
		assertTrue(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(0,3);
		assertFalse(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(7,5);
		assertTrue(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(4,1);
		assertTrue(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(3,8);
		assertTrue(barcoColocado);
		
		barcoColocado = mapa.comprobarLimiteTablero(3,4);
		assertFalse(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(5,5);
		assertFalse(barcoColocado);
		barcoColocado = mapa.comprobarLimiteTablero(6,2);
		assertFalse(barcoColocado);
	}
		
}
