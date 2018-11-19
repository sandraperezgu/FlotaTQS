package flotatqs;

public class Tablero {
	
	private static final int DIMENSION = 8;
	private Casilla[][] tablero = new Casilla[DIMENSION][DIMENSION];
	
	public Casilla[][] generarMapaVacio() {
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				Casilla c = new Casilla(i, j);
				this.tablero[i][j] = c;
			}
		}
		
		return this.tablero;
	}
	
}
