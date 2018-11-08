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

	// Método que convierte la columna que le llega por parámetro 
	// al número de columna correspondiente (0-7)
	public int caracterAnumerico(char columna) {
		String caracter = "ABCDEFGH";
		
		
		int posicion = caracter.indexOf(Character.toString(columna));
		
		return posicion;
	}
}
