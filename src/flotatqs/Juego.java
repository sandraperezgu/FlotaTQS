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
public class Juego {
    
	private Teclado teclado;
	
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
    
}
