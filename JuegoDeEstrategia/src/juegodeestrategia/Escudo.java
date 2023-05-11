package juegodeestrategia;

public class Escudo extends JuegoDeEstrategiaDecorator{
	//Un escudo, que aumenta la defensa ante ataques. Quien posea un escudo recibira 
	//solamente el 40 % del valor del ataque.
   
	public Escudo(Unidad u) {
		super(u);
		}
	@Override
    public void recibirDanio(int danio) {
		int danioEscudo= (danio*40)/100;
		//this.setSalud(this.getSalud()-Math.round(danioEscudo));
	   super.recibirDanio(Math.round(danioEscudo));
	}

	@Override
	public void atacar(Unidad u) {
		super.u.atacar(u);
		
	}

	@Override
	public boolean puedeAtacar(Unidad u) {
		
		return super.u.puedeAtacar(u);
	}
	
	
	




}