package flotatqs;

import java.util.Scanner;

public class Teclado {
	Scanner lector = new Scanner(System.in);

    public String leerPosicion(int longitud) {
        System.out.print("Colocar el barco de longitud " + longitud + " en la posición: ");
        String posicion = lector.next();

        return posicion;
    }

    public int leerDireccion() {
        System.out.print("En qué dirección quieres posicionar el barco?\n1.Vertical hacia arriba\n2.Vertical hacia abajo\n3.Horizontal hacia la derecha.\n4.Horizontal hacia la izquierda\nDirección: ");
        int direccion = lector.nextInt();
        
        return direccion;
    }
    
	public String leerPosicionAtaque() {
		System.out.print("Atacar la posición: ");
		String posicion = lector.next();
		
		return posicion;
	}
}
