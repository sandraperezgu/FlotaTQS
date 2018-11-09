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
		
		int numeroFila = caracterAnumerico(fila);
		Casilla c;
		boolean barcoColocado = false;
		switch(direccion) {
		// Si es una lancha no necesita saber una direccion
		case 0:
			c = this.mapa[numeroFila][columna-1];
			 
			if(!c.isBarco() && !barcosAlrededor(barco, fila, columna, direccion)) {
				c.setBarco(true);
				barcoColocado = true;
			}else {
				System.out.println("Ya hay un barco en esta posición. ");
			}
			break;
		}
		
		return barcoColocado;
	}

	public boolean barcosAlrededor(Barco barco, char fila, int columna, int direccion) {
		int numeroFila = caracterAnumerico(fila);
		Casilla c;
		boolean barcoColocado = false;
		
		switch(direccion) {
		// Si es una lancha no necesita saber una direccion
		case 0:
			if(!this.mapa[numeroFila+1][columna-1].isBarco() || !this.mapa[numeroFila][(columna-1)-1].isBarco() || !this.mapa[numeroFila-1][columna-1].isBarco() || !this.mapa[numeroFila][columna].isBarco()) {
				barcoColocado = true;
			}
			
			break;
		}
		return false;
	}

	public void setTablero(Tablero tab) {
		this.tablero = tab;
		this.mapa = generarMapaVacio();
	}
}
