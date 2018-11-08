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
	private Casilla[][] mapa = new Casilla[DIMENSION][DIMENSION];
	private Tablero tablero;
	
	public Mapa() {
		this.tablero = new Tablero();
		this.mapa = generarMapaVacio();
	}
	
	// Método que convierte la columna que le llega por parámetro 
	// al número de columna correspondiente (0-7)
	public int caracterAnumerico(char columna) {
		String caracter = "ABCDEFGH";
		
		
		int posicion = caracter.indexOf(Character.toString(columna));
		
		return posicion;
	}
	
	public Casilla[][] generarMapaVacio() {
		return this.tablero.generarMapa();
	}
	
	public Casilla[][] getTablero() {
		return this.mapa;
	}
	public boolean anadirBarco(Barco barco, char fila, int columna, int direccion) {
		return false;
	}

	public void setTablero(Tablero tab) {
		this.tablero = tab;
		this.mapa = generarMapaVacio();
	}
}
