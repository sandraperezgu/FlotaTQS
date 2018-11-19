package flotatqs;

public class MockTableroJugador extends Tablero{
	
	private static final int DIMENSION = 8;
	private Casilla[][] tablero = new Casilla[DIMENSION][DIMENSION];
	
		@Override
		public Casilla[][] generarMapaVacio() {
			// Añado barcos al mapa
			// Buque
			Barco b = new Barco(3);
			ponerParteBarco(b, 0, 0, true);
			ponerParteBarco(b, 1, 0, true);
			ponerParteBarco(b, 2, 0, true);
			
			// Buque
			b = new Barco(3);
			ponerParteBarco(b, 0, 3, false);
			ponerParteBarco(b, 0, 4, false);
			ponerParteBarco(b, 0, 5, true);
			// Buque
			b = new Barco(3);
			ponerParteBarco(b, 5, 1, false);
			ponerParteBarco(b, 5, 2, true);
			ponerParteBarco(b, 5, 3, false);
			// Lanchas
			b= new Barco(1);
			ponerParteBarco(b, 0, 7, false);
			b= new Barco(1);
			ponerParteBarco(b, 1, 6, true);
			b= new Barco(1);
			ponerParteBarco(b, 3, 1, true);
			b= new Barco(1);
			ponerParteBarco(b, 4, 0, false);
			b= new Barco(1);
			ponerParteBarco(b, 5, 5, false);
			// Portaviones
			b = new Barco(5); 
			ponerParteBarco(b, 3, 3, true);
			ponerParteBarco(b, 3, 4, true);
			ponerParteBarco(b, 3, 5, true);
			ponerParteBarco(b, 3, 6, true);
			ponerParteBarco(b, 3, 7, true);
			// Portaviones
			b = new Barco(5); 
			ponerParteBarco(b, 7, 0, true);
			ponerParteBarco(b, 7, 1, false);
			ponerParteBarco(b, 7, 2, false);
			ponerParteBarco(b, 7, 3, true);
			ponerParteBarco(b, 7, 4, false);
			
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
		
		public void ponerParteBarco(Barco b, int fila, int col, boolean tocado) {
	
			Casilla c = new Casilla(fila, col);
			this.tablero[fila][col] = c;
			c.setBarco(true);
			c.setTocado(tocado);
			b.setCasillas(c);
			c.setObjetoBarco(b);
		}

}
