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
public class Jugador {
	
	private Mapa mapa;
	
    public Jugador(Mapa mapa) {
    	this.mapa = mapa;
    }

	public boolean colocarBarco(Barco barco, char fila, int columna, int direccion) {
		return this.mapa.anadirBarco(barco, fila, columna, direccion);
	}
}
