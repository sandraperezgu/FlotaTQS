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

}
