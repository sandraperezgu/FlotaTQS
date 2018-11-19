package flotatqs;

public class MockPartida extends Partida{
	@Override
	public Jugador setJugador1(){
		
		Jugador jugador = new Jugador();
		jugador.crearMapa();
		
		return jugador;
	}
	
	@Override
	public Jugador setJugador2(){
		MockPerfil mperfil = new MockPerfil();
		Jugador jugador = new Jugador();
		jugador.setPerfilJugador(mperfil);
		jugador.crearMapa();
		
		return jugador;
	}
	
	@Override
	public void copiarMapaOponente(Jugador jugador1, Jugador jugador2) {
		
		jugador1.setMapaOculto(jugador2.getMapa());
	
	}
}
