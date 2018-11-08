package flotatqs;

public class MockTablero extends Tablero{
	
	private static final int DIMENSION = 8;
	private Casilla[][] tablero = new Casilla[DIMENSION][DIMENSION];
	
	// Este método crea un mapa falso con barcos
	@Override
	public Casilla[][] generarMapa() {
		// Añado barcos al mapa
		Casilla c = new Casilla(6, 1);
		this.tablero[6][1] = c;
		c.setBarco(true);
		
		c = new Casilla(2, 2);
		this.tablero[2][2] = c;
		c.setBarco(true);
		
		c = new Casilla(5, 3);
		this.tablero[5][3] = c;
		c.setBarco(true);
		
		c = new Casilla(3, 5);
		this.tablero[3][5] = c;
		c.setBarco(true);
		
		// Donde no hay barcos, coloco agua
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if(this.tablero[i][j]==null) {
					c = new Casilla(i, j);
					this.tablero[i][j] = c;
				}
			}
		}
		
		return this.tablero;
		
	}
}
