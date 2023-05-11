package juegodeestrategia;

public abstract class JuegoDeEstrategiaDecorator extends Unidad{
	public Unidad u;
	protected int danioreducido;
	protected int danioaumentado;
    //public Unidad e;
	public JuegoDeEstrategiaDecorator(Unidad u) {
		super(u.getSalud(),u.getPosicion(),u.getEnergia(),u.getDanio());	
		this.u=u;
		danioreducido=Math.round(u.getDanio()*10)/100;
		danioaumentado=u.getDanio()+3;

	}

	public int getCapaDanio() {
		return danioreducido;
	}
	
	@Override 
	public int getDanio() {
		return u.getDanio();
	}
	@Override 
	public void beberAgua() {
		this.u.beberAgua();

	}
	@Override
	public void atacar(Unidad enemigo) {
		this.u.atacar(enemigo);
		

	}
	@Override
	public boolean puedeAtacar(Unidad u) {
		// TODO Auto-generated method stub
		return  this.u.puedeAtacar(u);}
   
}