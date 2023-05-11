package juegodeestrategia;
/*
Los Arqueros pueden atacar a una distancia de entre 2 y 5 respecto de
su enemigo, y si tienen suficientes flechas. Comienzan con 20 flechas
en su carcaj, y pueden recargar si reciben un paquete de seis flechas.
Infringen un da�o de 5 puntos, y comienzan con 50 de salud.*/
public class Arquero extends Unidad {
	
	private int flechas;
	//private int danio;
	public Arquero(Punto posicion) {
		super(50,posicion,0,5);
		flechas=20;
	}
	@Override
	public void atacar(Unidad u) {
		if(this.puedeAtacar(u)) {
			u.recibirDanio(getDanioA());
			this.flechas-=1;
		}
	}
	public int getDanioA() {
		return super.getDanio();
	}
	@Override 
	public boolean puedeAtacar(Unidad u) {
		if(this.getPosicion().distancia(u.getPosicion())>=2 && this.getPosicion().distancia(u.getPosicion())<=5 && !this.estaMuerto() && this.tieneSuficientesFle())
		return true;
		else
		return false;
	}
	 
	
	public int getFlechas() {
		return flechas;
	}
	public void recargarFlechas() {
		flechas+=6;
	}
	private boolean tieneSuficientesFle() {
		if(getFlechas()>1)
			return true;
		else
		    return false;
	}
	@Override
	public void beberAgua() {
		// TODO Auto-generated method stub
		
	}
}
