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

}
