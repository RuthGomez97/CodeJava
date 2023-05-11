package juegodeestrategia;

/*Los lanceros pueden atacar a una distancia de 1 a 3, sin condici�n. 
Infringen un da�o de 25 puntos, y comienzan con 150 de salud.*/

public class Lancero extends Unidad{
	

	
	public Lancero(Punto posicion) {
		super(150,posicion,0,25);	
	}
	
	@Override
	public void atacar(Unidad u) {
		if(this.puedeAtacar(u)) {
			u.recibirDanio(getDanioL());
		}
	}
	public int getDanioL() {
		return super.getDanio();
	}
	
	@Override
	public boolean puedeAtacar(Unidad u) {
		if(this.getPosicion().distancia(u.getPosicion())>=1 && this.getPosicion().distancia(u.getPosicion())<=3 && !this.estaMuerto())
			return true;
		else
		return false;
	}

	@Override
	public void beberAgua() {
		// TODO Auto-generated method stub
		
	}
	
}
