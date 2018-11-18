package flotatqs;

public class Casilla {
	private boolean barco;
	private boolean tocado;
	private int fila;
	private int columna;
	
	public Casilla(int fila, int columna) {
		this.barco = false;
		this.fila = fila;
		this.columna = columna;
	}
	
	public boolean isBarco() {
		return this.barco;
	}
	
	public boolean isTocado() {
		return this.tocado;
	}
	
	public void setBarco(boolean barco) {
		this.barco = barco;
	}
	
	public void setTocado(boolean tocado) {
		this.tocado = tocado;
	}
}
