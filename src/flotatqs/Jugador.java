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
	private static final int LONGITUD_PORTAVIONES = 5;
	private static final int LONGITUD_BUQUES = 3;
	private static final int LONGITUD_LANCHAS = 1;
	public Jugador() {
		this.perfilJugador = new Perfil();
		generarListaBarcosJugador();
	}
	
	public void generarListaBarcosJugador() {
		// 10 barcos en total
		for (int i = 0; i < 5; i++) {
			// portaaviones
			if (i < 2) {
				this.barcos.add(new Barco(LONGITUD_PORTAVIONES));
			}
			// buques
			if (i < 3) {
				this.barcos.add(new Barco(LONGITUD_BUQUES));
			}
			// lanchas
			if (i < 5) {
				this.barcos.add(new Barco(LONGITUD_LANCHAS));
			}
		}
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

		Casilla c = this.mapa.getTablero()[numeroFila][columna - 1];
		int i = 0;
		
		if(c.getObjetoBarco().getLongitud()!=LONGITUD_LANCHAS) {
			while (hundido && i < c.getObjetoBarco().getCasillas().size()) {
				if (c.getObjetoBarco().getCasillas().get(i).isTocado() != null) {
					if (!c.getObjetoBarco().getCasillas().get(i).isTocado()) {
						hundido = false;
					}
				}else {
					hundido = false;
				}
				i++;
			}
		}else {
			if (c.getObjetoBarco().getCasillas().get(i).isTocado() != null) {
				if (!c.getObjetoBarco().getCasillas().get(i).isTocado()) {
					hundido = false;
				}
			}
		}
	
		return hundido;
	}

	// Método que hunde el barco
	public void hundirBarco(char fila, int columna) {
		int numeroFila = getMapa().caracterAnumerico(fila);

		Casilla c = this.mapa.getTablero()[numeroFila][columna - 1];
		c.getObjetoBarco().setHundido(true);
		
		int longitud = c.getObjetoBarco().getLongitud();
		eliminarBarcoLista(longitud);
	}
	
	public void eliminarBarcoLista(int longitud) {
		boolean eliminado = false;
		int i = 0;
		while(!eliminado && i<this.barcos.size()) {
			if(this.barcos.get(i).getLongitud()==longitud) {
				this.barcos.remove(i);
				eliminado = true;
			}
			i++;
		}
		
	}
}
