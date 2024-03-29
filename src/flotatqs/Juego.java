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
	private Partida partida;
	private Jugador jugador1;
	private Jugador jugador2;
	private static final int LONGITUD_LANCHAS = 1;
	
	public Juego() {
		this.teclado = new Teclado(); 
		this.partida = new Partida();
	}
	
	public void setTeclado(Teclado tec) {
        this.teclado = tec;
    }
	
	// M�todo que devuelve si la posici�n introducida por el jugador es correcta
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
		System.out.println("-------------------- Hundir la flota ------------------");
		System.out.println("-------------------------------------------------------");
		inicializarMapas();
		System.out.println("--------------- Que empiece la batalla! ---------------");
		System.out.println("-------------------------------------------------------");
		batalla();
		
	}

	public void setPartida(Partida p) {
		this.partida = p;
	}
	
	// M�todo donde cada jugador colocar� sus 10 barcos en su respectivo tablero
	public void inicializarMapas() {
		System.out.println("JUGADOR 1");
		setJugador1();
		
		colocarBarcos(jugador1);
		System.out.println("JUGADOR 2");
		
		setJugador2();
		
		colocarBarcos(jugador2);
		
		copiarMapaOponente(jugador1, jugador2);
		copiarMapaOponente(jugador2, jugador1);
		// Obtenemos el mapa del jugador 2 y lo guardamos oculto en el jugador 1
		//jugador1.setMapaOculto(jugador2.getMapa());
		// Obtenemos el mapa del jugador 1 y lo guardamos oculto en el jugador 2
		//jugador2.setMapaOculto(jugador1.getMapa());
	}
	
	public void copiarMapaOponente(Jugador jugador1, Jugador jugador2) {
		this.partida.copiarMapaOponente(jugador1, jugador2);
	}
	
	public Jugador getJugador1() {
		return this.jugador1;
	}
	
	public Jugador getJugador2() {
		return this.jugador2;
	}
	
	public void setJugador1() {
		this.jugador1 = this.partida.setJugador1();
	}
	
	public void setJugador2() {
		this.jugador2 = this.partida.setJugador2();
	}

	// M�todo que controlar� la colocaci�n de los barcos
	public void colocarBarcos(Jugador jugador) {
		String posicion;
		
		// Para cada barco
		for(int i = 0; i < jugador.getBarcos().size(); i++) {
			boolean barcoCorrecto = false;
			do {
				// Longitud del barco i de la lista de barcos del jugador
				Barco barco = jugador.getBarcos().get(i);
				int longitudBarco = barco.getLongitud();
				
				posicion = pedirPosicion(longitudBarco);
				
				if(comprobarPosicionCursor(posicion)) {
					// Cogemos el primer caracter del string, que es la fila
					char fila = posicion.charAt(0);
					// Cogemos el segundo caracter del string, que es la columna, pas�ndolo a valor num�rico
					int columna = Character.getNumericValue(posicion.charAt(1));
					
					// Si no es una lancha, pedimos la direcci�n en la que quiere colocar este barco
					if(longitudBarco!=LONGITUD_LANCHAS) {
						
						int direccion = pedirDireccion();
						
						// Comprobar que la direcci�n elegida para situar el barco no se salga del tablero.
						if(comprobarLimitesTablero(direccion, fila, columna, longitudBarco)) {
							barcoCorrecto = jugador.colocarBarco(barco, fila, columna, direccion);
							//jugador.setBarcos(barco); // a�ado el barco a la lista de barcos del jugador
							mensajeBarcoCorrecto(barcoCorrecto);
							
						}else {
							System.out.println("Imposible colocar el barco en esa direcci�n puesto que se sale del tablero.");
						}
						
					}else { // Si es una lancha simplemente habr� que comprobar si en esa posicion hay un barco
						barcoCorrecto = jugador.colocarBarco(barco, fila, columna, 0); // direccion = 0 --> valor por defecto si es una lancha
						//jugador.setBarcos(barco); // a�ado el barco a la lista de barcos del jugador
						mensajeBarcoCorrecto(barcoCorrecto);
					}
					
				}else {
					System.out.println("La posici�n no es correcta.");
				}
			}while(!barcoCorrecto);
		}
		
	}
	
	public void mensajeBarcoCorrecto(boolean barcoCorrecto) {
		if(!barcoCorrecto) {
			System.out.println("Ya hay un barco en esta posici�n o hay alguno alrededor. ");
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
			System.out.println("Direcci�n err�nea.");
		}

		return valido;
	}
	
	public void batalla() {
		boolean posicionOk= false;
		boolean ataqueCorrecto = false;
		boolean barcoHundido = false;
		Jugador jugador;
		int ganador = 0;
		do{
			if (turno == 0) {
				jugador = this.jugador1;
			} else {
				jugador = this.jugador2;
			}
			mostrarTurno();
			//Si le quedan barcos sin hundir al jugador 
			if (!jugador.getBarcos().isEmpty()) {
				// Mostrar los barcos NO hundidos
				mostrarBarcosSalvados(jugador);
				
				// Pedir posici�n mientras la introducida por el usuario es incorrecta
				do {
					// Mostramos el mapa del jugador y el del oponente (oculto)
					mostrarMapas(jugador);
					// Pedimos la posici�n a atacar
					String posicionAtaque = pedirPosicionAtaque();
					// Si la posicion es correcta, entonces
					if (comprobarPosicionCursor(posicionAtaque)) {
						// Cogemos el primer caracter del string, que es la fila
						char fila = posicionAtaque.charAt(0);
						// Cogemos el segundo caracter del string, que es la columna, pas�ndolo a valor
						// num�rico
						int columna = Character.getNumericValue(posicionAtaque.charAt(1));
						// Comparamos la posicion indicada con el mapa real del oponente
						// para saber si hay parte de un barco
						ataqueCorrecto = compararMapas(fila, columna);
						// Si hay parte de un barco, entonces
						if(ataqueCorrecto) {
							// Se comprueba si el barco est� completamente tocado 
							// para ser hundido
							barcoHundido = jugador.isBarcoHundido(fila, columna);
							// Si debe ser hundido, entonces
							if(barcoHundido) {
								if(turno==0) {
									jugador2.hundirBarco(fila, columna);
								}else {
									jugador1.hundirBarco(fila, columna);
								}
								System.out.println("Barco hundido");
								ganador = comprobarGanador();
							}
							posicionOk = true;
							
						}else {
							//if(posicionOk) {
								pasarTurno();
							//}
						}
						jugador.getMapaOculto().pintarMapaOculto();						
					}
				} while (!posicionOk);
			}
		}while(ganador==0);
		
		
	}

	public void pasarTurno() {
		if (turno == 1) {
			turno = 0;
		} else {
			turno++;
		}
	}
	
	public int comprobarGanador() {
		int ganador = 0;
		if(jugador1.getBarcos().isEmpty()) {
			ganador = 1;
		}else if(jugador2.getBarcos().isEmpty()){
			ganador = 2;
		}
		
		return ganador;
	}

	public void mostrarMapas(Jugador jugador) {
		// muestra el mapa del jugador actual con sus barcos (tocados (T), hundidos (H), estables (B))
		System.out.println("\nMI MAPA");
		jugador.getMapa().pintarMapa();
		// muestra el mapa del oponente oculto, destapando las casillas que atacamos segun est�n tocadas (T) o con agua (O) 
		System.out.println("\nMAPA ENEMIGO");
		// Mapa oculto que se ir� rellenando
		jugador.getMapaOculto().pintarMapaOculto();
	}
	
	public void mostrarTurno() {
		if (turno == 0) {
			System.out.println("Turno jugador 1");
		} else {
			System.out.println("Turno jugador 2");
		}
	}
	
	public void mostrarBarcosSalvados(Jugador jugador) {
		System.out.println("Barcos a salvo: ");

		for (int i = 0; i < jugador.getBarcos().size(); i++) {
			if (jugador.getBarcos().get(i).getLongitud() == 5) {
				System.out.print("\tPortaavion");
			} else if (jugador.getBarcos().get(i).getLongitud() == 3) {
				System.out.print("\tBuque");
			} else {
				System.out.print("\tLancha");
			}

		}
		System.out.println();
	}
	
	public String pedirPosicionAtaque() {
		return this.teclado.leerPosicionAtaque();
	}
		
	public boolean compararMapas(char fila, int columna) {
		boolean tocado = false;
		int numeroFila = this.jugador1.getMapa().caracterAnumerico(fila);
				
		if(turno==0) {
			if(this.jugador1.getCasillasMapaOculto()[numeroFila][columna-1].isBarco()) {
				this.jugador2.getCasillasMapa()[numeroFila][columna-1].setTocado(true);
		
				tocado = true;
			}else {
				this.jugador2.getCasillasMapa()[numeroFila][columna-1].setTocado(false);
			}
		}else {
			if(this.jugador2.getCasillasMapaOculto()[numeroFila][columna-1].isBarco()) {
				this.jugador1.getCasillasMapa()[numeroFila][columna-1].setTocado(true);
		
				tocado = true;
			}else {
				this.jugador1.getCasillasMapa()[numeroFila][columna-1].setTocado(false);
			}
		}
		
		//this.jugador1.getMapaOculto().pintarMapaOculto();
		
		return tocado;
	}
    
}
