package flotatqs;

public class Partida {
	
	public Jugador setJugador1(){
		Jugador jugador = new Jugador();
		jugador.crearMapa();
		
		return jugador;
	}
	
	
	public Jugador setJugador2(){
		Jugador jugador = new Jugador();
		jugador.crearMapa();
		
		return jugador;
	}
	
	public void copiarMapaOponente(Jugador jugador1, Jugador jugador2) {
		
		jugador1.setMapaOculto(jugador2.getMapa());
	
	}
	
}
