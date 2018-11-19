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
public class Barco {
	private int longitud;
	private boolean hundido;
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
	
    public Barco(int longitud) {
    	this.longitud = longitud;
    	this.hundido = false;
    }

	public int getLongitud() {
		return this.longitud;
	}
	
	public void setCasillas(Casilla c) {
		this.casillas.add(c);
	}
	
	public ArrayList<Casilla> getCasillas() {
		return this.casillas;
	}
	
	public boolean isHundido() {
		return this.hundido;
	}
	
	public void setHundido(boolean hundido) {
		this.hundido = hundido;
	}
}
