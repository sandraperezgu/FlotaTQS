/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flotatqs;

/**
 *
 * @author Sandra
 */
public class Mapa {

	private static final int DIMENSION = 8;
	private Casilla[][] tablero = new Casilla[DIMENSION][DIMENSION];
	
	public Mapa() {
		generarMapaVacio();
	}
	// Método que convierte la columna que le llega por parámetro 
	// al número de columna correspondiente (0-7)
	public int caracterAnumerico(char columna) {
		String caracter = "ABCDEFGH";
		
		
		int posicion = caracter.indexOf(Character.toString(columna));
		
		return posicion;
	}
	
	public void generarMapaVacio() {
		
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				Casilla c = new Casilla(i, j);
				this.tablero[i][j] = c;
			}
		}
	}
	
	public Casilla[][] getTablero() {
		return this.tablero;
	}
}
