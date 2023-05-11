package juegodeestrategia;
/*Los caballeros pueden atacar a una distancia de 1 a 2,
siempre que su caballo no se haya puesto rebelde. Infringe un da�o de 50 puntos y
comienza con 200 de salud. Un caballo 
se pone rebelde luego de 3 ataques, y puede calmarse si recibe una raci�n de agua.*/
public class Caballero extends Unidad {
	//private final int DANIO=50;
	private Caballo caballito;
	public Caballero(Punto posicion, Caballo caballo) {
		super(200,posicion,0,50);
		this.caballito=caballo;
	}
	@Override
	public void atacar(Unidad u) {
		if(this.puedeAtacar(u)) {
			this.caballito.incrementarAtaques();
			u.recibirDanio(getDanioC());
		}
		
	}
	public int getDanioC() {
		return super.getDanio();
	}
	
	@Override
	public boolean puedeAtacar(Unidad u) {
		return this.getPosicion().distancia(u.getPosicion())>=1 && this.getPosicion().distancia(u.getPosicion())<=2 && !(this.estaMuerto()) && !(this.caballito.estaRebelde());
			
	}
	public void beberAgua(){
		this.caballito.beberAgua();
	}
	
	
	// public void calmarCaballo() {
	//	 this.caballito.beberAgua();
	 //}
	
}
