package juegodeestrategia;

public class Capa  extends JuegoDeEstrategiaDecorator{
  
	public Capa(Unidad u) {
		super(u);
		u.setDanio(danioreducido);
       
	}
	
		
    public int getDanioReducido() {
    	return this.danioreducido;
    }
	//Una capa, que duplica la energıa de la unidad. Sin embargo, reduce
	//la fuerza de los ataques en
	//un 10 % porque obstaculiza su movimiento.
    
	
    
	@Override
	public void atacar(Unidad u) {
		super.u.atacar(u);
		 
	}
	@Override
	public int getEnergia() {
		return super.u.getEnergia()*2;
	}

}
