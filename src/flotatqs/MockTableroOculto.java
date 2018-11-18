package flotatqs;

public class MockTableroOculto extends Tablero{
	
	private static final int DIMENSION = 8;
	private Casilla[][] tablero = new Casilla[DIMENSION][DIMENSION];
	
		@Override
		public Casilla[][] generarMapa() {
			// Añado barcos al mapa
			// Buque
			ponerParteBarco(0, 0);
			ponerParteBarco(1, 0);
			ponerParteBarco(2, 0);
			
			// Buque
			ponerParteBarco(0, 3);
			ponerParteBarco(0, 4);
			ponerParteBarco(0, 5);
			// Buque
			ponerParteBarco(5, 1);
			ponerParteBarco(5, 2);
			ponerParteBarco(5, 3);
			// Lanchas
			ponerParteBarco(0, 7);
			ponerParteBarco(1, 6);
			ponerParteBarco(3, 1);
			ponerParteBarco(4, 0);
			ponerParteBarco(5, 5);
			// Portaviones
			ponerParteBarco(3, 3);
			ponerParteBarco(3, 4);
			ponerParteBarco(3, 5);
			ponerParteBarco(3, 6);
			ponerParteBarco(3, 7);
			// Portaviones
			ponerParteBarco(7, 0);
			ponerParteBarco(7, 1);
			ponerParteBarco(7, 2);
			ponerParteBarco(7, 3);
			ponerParteBarco(7, 4);

			// Donde no hay barcos, coloco agua
			for (int i = 0; i < DIMENSION; i++) {
				for (int j = 0; j < DIMENSION; j++) {
					if(this.tablero[i][j]==null) {
						Casilla c = new Casilla(i, j);
						this.tablero[i][j] = c;
					}
				}
			}
			
			return this.tablero;
		
		}
		
		public void ponerParteBarco(int fila, int col) {
			Casilla c = new Casilla(fila, col);
			this.tablero[fila][col] = c;
			c.setBarco(true);
		}

}
