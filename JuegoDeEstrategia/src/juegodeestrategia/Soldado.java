package juegodeestrategia;

//UN SOLDADO TIENE 200 DE salud, INFLIGE UN DANIO DE 10 Y TIENE 100 de energia;
public class Soldado extends Unidad implements Bebedor {
	
	
	//private int danio;
	
	private static int energiaconsumida=10;
	public Soldado(Punto posicion){
		super(200,posicion,100,10);
		
	}
	
	public int  getDanioS() {
		return this.getDanio();
	}
	@Override
	public void atacar(Unidad enemigo) {
		if(this.puedeAtacar(enemigo)) {
		   this.setEnergia(getEnergia()-energiaconsumida);
			enemigo.recibirDanio(this.getDanioS());
		}
	}
	
	  
	@Override
	//puyede atacar si el soldado no esta muerto si tiene mas de 10 de energia y si la distancia es 0 con el la otra unidad
	public boolean puedeAtacar(Unidad u) {
		return(!this.estaMuerto() && this.getPosicion().distancia(u.getPosicion())==0 && super.getEnergia()>=10);		
	}
	/*
	public void infringirDanio(Unidad u){
     u.recibirDanio(danio);
	}*/
	//el soldado repone energia si bebe agua vuelve a su energia inicial o sea 100
    @Override
    public void beberAgua() {
    	super.setEnergia(100);
    	System.out.println("bebi agua");
    	
    }
}
