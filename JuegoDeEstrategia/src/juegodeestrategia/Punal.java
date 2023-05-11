package juegodeestrategia;

public class Punal extends JuegoDeEstrategiaDecorator {

	public Punal(Unidad u) {
		super(u);
		u.setDanio(danioaumentado);
		
	}
	//Un pu ̃nal, que aumenta la fuerza de los ataques en 3 puntos pero reduce la defensa tambi ́en en
	//3 puntos por inutilizar la otra mano.
	
	@Override
    public void recibirDanio(int danio) {
		int daniopunal= danio+3;
		//this.setSalud(this.getSalud()-Math.round(danioEscudo));
	   super.recibirDanio(Math.round(daniopunal));
	}
	
	

}
