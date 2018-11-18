package flotatqs;

public class Casilla {
	private boolean barco;
	private Boolean tocado;
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
	
	public Boolean isTocado() {
		return this.tocado;
	}
	
	public void setBarco(boolean barco) {
		this.barco = barco;
	}
	
	public void setTocado(Boolean tocado) {
		this.tocado = tocado;
	}
}
