package flotatqs;

public class MockTeclado extends Teclado {
	// String[] posiciones = { "A1", "B2", "H1", "Z1" };
	String[] posiciones = { "A1", "B2", "H1", "Z1", "H1", "H3", "A1", "A8", "F3", "B2", "B4", "B5", "F6", "A3", "G8",
			"A7", "G8", "A1", "H1", "C1", "F2", "A5", "E3", "E5", "A3", "A8" };
	String[] posicionAtaque = {"A1"};
	int[] direcciones = { 2, 1, 0, 2, 1, 3, 0, 2, 1, 0, 2, 2, 0, 0, 0, 2, 4, 0, 3, 3, 0, 2, 0, 0, 0, 1 };
	// int[] direcciones = { 2, 2, 0, 2 };

	int i = 0;

	@Override
	public String leerPosicion(int longitud) {
		if (i == 26) {
			i = 0;
		}
		String posicion;
		System.out.print("Colocar el barco de longitud " + longitud + " en la posición: ");

		posicion = posiciones[i];
		System.out.println(posicion);

		if (longitud == 1 || i < 4) {
			i++;
		}

		return posicion;
	}

	@Override
	public int leerDireccion() {

		System.out.print(
				"En qué dirección quieres posicionar el barco?\n1.Vertical hacia arriba\n2.Vertical hacia abajo\n3.Horizontal hacia la derecha.\n4.Horizontal hacia la izquierda\nDirección: ");
		int direccion = direcciones[i];

		i++;

		System.out.println(direccion);

		return direccion;
	}

	@Override
	public String leerPosicionAtaque() {
		if (i == 25) {
			i = 0;
		}
			
		System.out.print("Atacar la posición: ");
		String posicion = posicionAtaque[i];
		System.out.println(posicion);
		i++;
		return posicion;
	}

}
