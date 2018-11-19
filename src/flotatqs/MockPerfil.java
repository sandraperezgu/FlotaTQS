package flotatqs;

public class MockPerfil extends Perfil {

	@Override
	public Mapa generarMapaJugador(){
		
		Mapa mapa = new Mapa();
		MockTableroJugador mto = new MockTableroJugador();
		mapa.setTablero(mto);
		mapa.mapaVacio();
		
		mapa.pintarMapa();
		return mapa; 
		
	}
}
