package flotatqs;

public class Casilla {
	private boolean barco;
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
}
