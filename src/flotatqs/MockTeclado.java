package flotatqs;

public class MockTeclado extends Teclado {
	String[] posiciones = { "A1", "B2", "H1", "Z1" };

	int[] direcciones = { 2, 2, 0, 2 };

	int i = 0;

	@Override
	public String leerPosicion(int longitud) {

		System.out.print("Colocar el barco de longitud " + longitud + " en la posici�n: ");
		String posicion = posiciones[i];

		System.out.println(posicion);

		i++;

		return posicion;
	}

	@Override
	public int leerDireccion() {

		System.out.print(
				"En qu� direcci�n quieres posicionar el barco?\n1.Vertical hacia arriba\n2.Vertical hacia abajo\n3.Horizontal hacia la derecha.\n4.Horizontal hacia la izquierda\nDirecci�n: ");
		int direccion = direcciones[i];
		i++;
		System.out.println(direccion);

		return direccion;
	}
}
