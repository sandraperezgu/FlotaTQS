package flotatqs;

public class MockTablero extends Tablero{
	
	private static final int DIMENSION = 8;
	private Casilla[][] tablero = new Casilla[DIMENSION][DIMENSION];
	
	// Este m�todo crea un mapa falso con barcos
	@Override
	public Casilla[][] generarMapa() {
		// A�ado barcos al mapa
		Casilla c = new Casilla(5, 1);
		this.tablero[5][1] = c;
		c.setBarco(true);
		
		c = new Casilla(1, 2);
		this.tablero[1][2] = c;
		c.setBarco(true);
		
		c = new Casilla(5, 3);
		this.tablero[5][3] = c;
		c.setBarco(true);
		
		c = new Casilla(3, 5);
		this.tablero[3][5] = c;
		c.setBarco(true);
		
		c = new Casilla(0, 0);
		this.tablero[0][0] = c;
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
