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
		Casilla c = this.mapa[numeroFila][columna-1];
		boolean barcoColocado = false;
		switch(direccion) {
		// Si es una lancha no necesita saber una direccion
		case 0:
			//c = this.mapa[numeroFila][columna-1];
			 
			if(!c.isBarco() && barcosAlrededor(barco, fila, columna, direccion)) {
				c.setBarco(true);
				barcoColocado = true;
			}else {
				System.out.println("Ya hay un barco en esta posición. ");
			}
			break;
		case 1:
			
			
			if(barcosAlrededor(barco, fila, columna, direccion)) {
				
				for (int i=0; i < barco.getLongitud(); i++) {
					c = this.mapa[numeroFila][columna-1];
                    c.setBarco(true);
					numeroFila = numeroFila+1;
	            }
				barcoColocado = true;
				
				
			}
			break;
		case 2:
			
			if(barcosAlrededor(barco, fila, columna, direccion)) {
				for (int i=0; i < barco.getLongitud(); i++) {
					c = this.mapa[numeroFila][columna-1];
                    c.setBarco(true);
					numeroFila = numeroFila-1;
	            }
				barcoColocado = true;
				
			}
			break;
		case 3:
			
			if(barcosAlrededor(barco, fila, columna, direccion)) {
				for (int i=0; i < barco.getLongitud(); i++) {
					c = this.mapa[numeroFila][columna-1];
                    c.setBarco(true);
					columna = columna-1;
	            }
				
				
			}
			break;
		case 4:
			
			if(barcosAlrededor(barco, fila, columna, direccion)) {
				for (int i=0; i < barco.getLongitud(); i++) {
					c = this.mapa[numeroFila][columna-1];
                    c.setBarco(true);
					columna = columna+1;
	            }
				barcoColocado = true;
				
			}
			break;
		}
		
		return barcoColocado;
	}
	
	public boolean barcosAlrededor(Barco barco, char fila, int columna, int direccion) {
		int numeroFila = caracterAnumerico(fila);
		Casilla c;
		boolean colocarBarco = false;
		
		switch(direccion) {
		// Si es una lancha no necesita saber una direccion
		case 0:
			if(numeroFila>0 && numeroFila<7 && (columna-1)>0 && (columna-1)<7) {
				if(!this.mapa[numeroFila+1][columna-1].isBarco() && !this.mapa[numeroFila][(columna-1)-1].isBarco() && !this.mapa[numeroFila-1][columna-1].isBarco() && !this.mapa[numeroFila][columna].isBarco()) {
					colocarBarco = true;
				}
			}else{
				colocarBarco = comprobarLimiteTablero(numeroFila, columna);
			}
			break;
		case 1: // Vertical hacia arriba
			colocarBarco = true;
            int j = 0;
            while (j < barco.getLongitud() && colocarBarco) {
            	colocarBarco = comprobarPosicionParaAnadir(numeroFila, columna);
				numeroFila = numeroFila-1;
                j++;
            }
			
			break;
		case 2:
			// Vertical hacia abajo
			colocarBarco = true;
            j = 0;
            while (j < barco.getLongitud() && colocarBarco) {
            	colocarBarco = comprobarPosicionParaAnadir(numeroFila, columna);
				numeroFila = numeroFila+1;
                j++;
            }
			break;
		case 3:
			// Horizontal hacia la derecha
			colocarBarco = true;
            j = 0;
            while (j < barco.getLongitud() && colocarBarco) {
            	colocarBarco = comprobarPosicionParaAnadir(numeroFila, columna);
				columna = columna+1;
                j++;
            }
            break;
		case 4:
			colocarBarco = true;
            j = 0;
            while (j < barco.getLongitud() && colocarBarco) {
            	colocarBarco = comprobarPosicionParaAnadir(numeroFila, columna);
				columna = columna-1;
                j++;
            }
            break;
		}
		return colocarBarco;
	}

	public void setTablero(Tablero tab) {
		this.tablero = tab;
		this.mapa = generarMapaVacio();
	}
	
	public boolean comprobarLimiteTablero(int numeroFila, int columna) {
		boolean colocarBarco = false;
		if(numeroFila==0 && (columna-1)==0) { // esquina superior izquierda
			if(!this.mapa[numeroFila+1][columna-1].isBarco() && !this.mapa[numeroFila][columna].isBarco()) {
				colocarBarco = true;
			}
		}else if(numeroFila==7 && (columna-1)==0) { // esquina inferior izquierda
			if(!this.mapa[numeroFila-1][columna-1].isBarco() && !this.mapa[numeroFila][columna].isBarco()) {
				colocarBarco = true;
			}
		}else if(numeroFila==0 && (columna-1)==7) { // esquina superior derecha
			if(!this.mapa[numeroFila][(columna-1)-1].isBarco() && !this.mapa[numeroFila+1][(columna-1)].isBarco()) {
				colocarBarco = true;
			}
		}else if(numeroFila==7 && (columna-1)==7) { // esquina inferior derecha
			if(!this.mapa[numeroFila-1][(columna-1)].isBarco() && !this.mapa[numeroFila][(columna-1)-1].isBarco()) {
				colocarBarco = true;
			}
		}else if(numeroFila==0) { // fila 0 (no esquinas)
			if(!this.mapa[numeroFila+1][columna-1].isBarco() && !this.mapa[numeroFila][(columna-1)-1].isBarco() && !this.mapa[numeroFila][columna].isBarco()) {
				colocarBarco = true;
			}
		}else if(numeroFila==7) { // fila 7 (no esquinas)
			if(!this.mapa[numeroFila][(columna-1)-1].isBarco() && !this.mapa[numeroFila-1][columna-1].isBarco() && !this.mapa[numeroFila][columna].isBarco()) {
				colocarBarco = true;
			}
		}else if((columna-1)==0) { // columna 0 (no esquinas)
			if(!this.mapa[numeroFila+1][columna-1].isBarco()  && !this.mapa[numeroFila-1][columna-1].isBarco() && !this.mapa[numeroFila][columna].isBarco()) {
				colocarBarco = true;
			}
		}else if((columna-1)==7) { // columna 7 (no esquinas)
			if(!this.mapa[numeroFila+1][columna-1].isBarco() && !this.mapa[numeroFila][(columna-1)-1].isBarco() && !this.mapa[numeroFila-1][columna-1].isBarco()) {
				colocarBarco = true;
			}
		}
		
		return colocarBarco;
	}
	
	public boolean comprobarPosicionParaAnadir(int numeroFila, int columna) {
		boolean colocarBarco = true;
		if(numeroFila>0 && numeroFila<7 && (columna-1)>0 && (columna-1)<7) {
			if(!this.mapa[numeroFila+1][columna-1].isBarco() && !this.mapa[numeroFila][(columna-1)-1].isBarco() && !this.mapa[numeroFila-1][columna-1].isBarco() && !this.mapa[numeroFila][columna].isBarco()) {
				colocarBarco = true;
			}else {
				colocarBarco = false;
			}
		}else {
			colocarBarco = comprobarLimiteTablero(numeroFila, columna);
		}
		return colocarBarco;
	}
		
}
