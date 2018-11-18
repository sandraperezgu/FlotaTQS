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
public class Juego {
    
	private static int turno = 0;
	private Teclado teclado;
	private Jugador jugador1;
	private Jugador jugador2;
	private ArrayList<Barco> listaBarcosJugador = new ArrayList<Barco>();
	private static final int LONGITUD_PORTAVIONES = 5;
	private static final int LONGITUD_BUQUES = 3;
	private static final int LONGITUD_LANCHAS = 1;
	
	public Juego() {
		this.teclado = new Teclado(); 
		generarListaBarcosJugador();
	}
	
	public void generarListaBarcosJugador() {
		// 10 barcos en total
		for (int i = 0; i < 5; i++) {
			// portaaviones
			if (i < 2) {
				this.listaBarcosJugador.add(new Barco(LONGITUD_PORTAVIONES));
			}
			// buques
			if (i < 3) {
				this.listaBarcosJugador.add(new Barco(LONGITUD_BUQUES));
			}
			// lanchas
			if (i < 5) {
				this.listaBarcosJugador.add(new Barco(LONGITUD_LANCHAS));
			}
		}
	}

	public void setTeclado(Teclado tec) {
        this.teclado = tec;
    }
	
	// Método que devuelve si la posición introducida por el jugador es correcta
    public boolean comprobarPosicionCursor(String posicion) {
   	
    	boolean valido = false;
    	if(posicion.length()==2) {
    		char fila = posicion.charAt(0);
        	int columna = Character.getNumericValue(posicion.charAt(1));
        	
    		if((columna>=1 && columna<=8) && (fila>='A' && fila<='H')) {
    			valido =  true;
    		}
    		
    	}
    	return valido;
    }
    
    public String pedirPosicion(int longitud) {
    	return this.teclado.leerPosicion(longitud);
    }
    
    public int pedirDireccion() {
    	return this.teclado.leerDireccion();
    }

	public void iniciarJuego() {
		System.out.println("Hundir la flota");
		System.out.println("---------------");
		
		inicializarMapas();
		
	}

	// Método donde cada jugador colocará sus 10 barcos en su respectivo tablero
	public void inicializarMapas() {
		this.jugador1 = new Jugador();
		colocarBarcos(jugador1);
		this.jugador2 = new Jugador();
		colocarBarcos(jugador2);
		jugador1.setMapaOculto(jugador2.getCasillasMapa());
		jugador2.setMapaOculto(jugador1.getCasillasMapa());
	}

	// Método que controlará la colocación de los barcos
	public void colocarBarcos(Jugador jugador) {
		String posicion;
		
		// Para cada barco
		for(int i = 0; i < listaBarcosJugador.size(); i++) {
			boolean barcoCorrecto = false;
			do {
				// Longitud del barco i de la lista de barcos del jugador
				Barco barco = listaBarcosJugador.get(i);
				int longitudBarco = barco.getLongitud();
				
				posicion = pedirPosicion(longitudBarco);
				
				if(comprobarPosicionCursor(posicion)) {
					// Cogemos el primer caracter del string, que es la fila
					char fila = posicion.charAt(0);
					// Cogemos el segundo caracter del string, que es la columna, pasándolo a valor numérico
					int columna = Character.getNumericValue(posicion.charAt(1));
					
					// Si no es una lancha, pedimos la dirección en la que quiere colocar este barco
					if(longitudBarco!=LONGITUD_LANCHAS) {
						
						int direccion = pedirDireccion();
						
						// Comprobar que la dirección elegida para situar el barco no se salga del tablero.
						if(comprobarLimitesTablero(direccion, fila, columna, longitudBarco)) {
							barcoCorrecto = jugador.colocarBarco(barco, fila, columna, direccion);
							mensajeBarcoCorrecto(barcoCorrecto);
						}else {
							System.out.println("Imposible colocar el barco en esa dirección puesto que se sale del tablero.");
						}
						
					}else { // Si es una lancha simplemente habrá que comprobar si en esa posicion hay un barco
						barcoCorrecto = jugador.colocarBarco(barco, fila, columna, 0); // direccion = 0 --> valor por defecto si es una lancha
						mensajeBarcoCorrecto(barcoCorrecto);
					}
					
				}else {
					System.out.println("La posición no es correcta.");
				}
			}while(!barcoCorrecto);
		}
		
	}
	
	public void mensajeBarcoCorrecto(boolean barcoCorrecto) {
		if(!barcoCorrecto) {
			System.out.println("Ya hay un barco en esta posición o hay alguno alrededor. ");
		}else {
			System.out.println("Barco introducido!!");
		}
	}

	public boolean comprobarLimitesTablero(int direccion, char fila, int columna, int longitudBarco) {
		boolean valido = false;
		switch (direccion) {
		case 1:
			if ((longitudBarco == 3 && fila >= 'C') || (longitudBarco == 5 && fila >= 'E')) {
				valido = true;
			}
			System.out.println("Has elegido Vertical hacia arriba");
			break;
		case 2:
			if ((longitudBarco == 3 && fila <= 'F') || (longitudBarco == 5 && fila <= 'D')) {
				valido = true;
			}
			System.out.println("Has elegido Vertical hacia abajo");
			break;
		case 3:
			if ((longitudBarco == 3 && (columna - 1) < 6) || (longitudBarco == 5 && (columna - 1) < 4)) {
				valido = true;
			}
			System.out.println("Horizontal - derecha");
			break;
		case 4:
			if ((longitudBarco == 3 && (columna - 1) >= 2) || (longitudBarco == 5 && (columna - 1) >= 4)) {
				valido = true;
			}
			System.out.println("Horizontal - izq");
			break;
		default:
			System.out.println("Dirección errónea.");
		}

		return valido;
	}
	
	public boolean compararMapas(char fila, int columna) {
		boolean tocado = false;
		int numeroFila = this.jugador1.getMapa().caracterAnumerico(fila);
				
		if(turno==0) {
			if(this.jugador1.getCasillasMapaOculto()[numeroFila][columna].isBarco()) {
				this.jugador2.getCasillasMapa()[numeroFila][columna].setTocado(true);
				tocado = true;
			}else {
				this.jugador2.getCasillasMapa()[numeroFila][columna].setTocado(false);
			}
		}
		
		this.jugador1.getMapaOculto().pintarMapaOculto();
		
		return tocado;
	}
    
}
