package juegodeestrategia;

public abstract class Unidad implements Bebedor {
	private int salud;
	private Punto posicion;
	private int energia;
	private int danio;

	public Unidad(int salud,Punto posicion,int energia, int danio) {
		this.salud=salud;
		this.posicion=posicion;
		this.energia=energia;
		this.danio=danio;
		
	}
	
	public abstract void atacar(Unidad u);
	public abstract boolean puedeAtacar(Unidad u);
    public abstract void beberAgua();

    public boolean estaMuerto(){
		return this.getSalud()==0;
	}
	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio=danio;
	}
	public int getEnergia() { 
		return this.energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public double distancia(Unidad u) {
		return this.posicion.distancia(u.posicion);
	}
	
//el problema ahora es de quien recibie el danio tengo que manejar eso tambien
	
	public void recibirDanio(int danio) {
		this.salud-=danio;
	}
	
	protected void setSalud(int s) {
		this.salud=s;
	}
	public int getSalud() {
		if(salud>=0){
		return this.salud;
		}else {
			return 0;
		}
	}
	public Punto getPosicion() {
		return posicion;
	}
}