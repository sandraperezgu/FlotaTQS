package flotatqs;

public class MockTeclado extends Teclado {
	//String[] posiciones = { "A1", "B2", "H1", "Z1" };
	String[] posiciones = { "A1", "B2", "H1", "Z1", "H1", "H3", "A1", "A8", "F3", "B2", "B4", "B5", "F6", "A3", "G8",  "H1", "H3", "A1", "A8", "F3", "B2", "B4", "B5", "F6", "A3", "G8" };
	int[] direcciones = { 2, 2, 0, 2, 1, 3, 0, 2, 1, 0, 2, 2, 0, 0, 0,  1, 3, 0, 2, 1, 0, 2, 2, 0, 0, 0};
	//int[] direcciones = { 2, 2, 0, 2 };

	int i = 0;

	@Override
	public String leerPosicion(int longitud) {
		//Juego juego = new Juego();
		System.out.print("Colocar el barco de longitud " + longitud + " en la posición: ");
		String posicion = posiciones[i];

		System.out.println(posicion);

		if(longitud==1 || i<4){
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
}
