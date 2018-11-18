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
	private Mapa mapaOculto;
	
    public Jugador() {
    	this.mapa = new Mapa();
    }
    
    public Mapa getMapa() {
    	return this.mapa;
    }
    
    public Mapa getMapaOculto() {
    	return this.mapaOculto;
    }

    public Casilla[][] getCasillasMapa() {
    	return this.mapa.getMapa();
    }
    
	public boolean colocarBarco(Barco barco, char fila, int columna, int direccion) {
		return this.mapa.anadirBarco(barco, fila, columna, direccion);
	}
	
	public void setMapaOculto(Casilla[][] oculto) {
		this.mapaOculto.setTablero(oculto);
	}
	
	public Casilla[][] getCasillasMapaOculto() {
		return this.mapaOculto.getMapa();
	}
}
