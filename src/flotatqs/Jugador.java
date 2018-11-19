/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flotatqs;

import java.util.ArrayList;

/**
 *
 * @author Sandra
 */
public class Jugador {
	
	private Mapa mapa;
	private Mapa mapaOculto;
	private ArrayList<Barco> barcos = new ArrayList<Barco>();
    private Perfil perfilJugador;
    public Jugador() {
    	this.perfilJugador = new Perfil();
    }
    
   
    public void setPerfilJugador(Perfil p) {
    	this.perfilJugador = p;
    }

    public void crearMapa() {
    	
    	this.mapa = this.perfilJugador.generarMapaJugador();
    }
        
    public ArrayList<Barco> getBarcos() {
    	return this.barcos;
    }
    
    public void setBarcos(Barco barco) {
    	this.barcos.add(barco);
    }
    
    public Mapa getMapa() {
    	return this.mapa;
    }
    
    public Mapa getMapaOculto() {
    	return this.mapaOculto;
    }

    public Casilla[][] getCasillasMapa() {
    	return this.mapa.getTablero();
    }
    
	public boolean colocarBarco(Barco barco, char fila, int columna, int direccion) {
		return this.mapa.anadirBarco(barco, fila, columna, direccion);
	}
	
	public void setMapaOculto(Mapa oculto) {
		this.mapaOculto = oculto;
	}
	
	public Casilla[][] getCasillasMapaOculto() {
		return this.mapaOculto.getTablero();
	}

	// Comprobar si el barco está hundido 
	public boolean isBarcoHundido(char fila, int columna) {
		int numeroFila = getMapa().caracterAnumerico(fila);
		
		boolean hundido = true;
		

		Casilla c = this.mapa.getTablero()[numeroFila][columna-1];
		for(int i = 0; i< c.getObjetoBarco().getCasillas().size();i++) {
			while(hundido) {
				if(!c.getObjetoBarco().getCasillas().get(i).isTocado()) {
					hundido = false;
				}
			}
		}
		return hundido;
	}
}
