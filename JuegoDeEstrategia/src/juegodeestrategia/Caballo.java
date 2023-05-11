package juegodeestrategia;

public class Caballo implements Bebedor{
	
	private int cantAtaques=0;
	
	@Override
	public void beberAgua(){
		this.cantAtaques=0;
	}
	public void incrementarAtaques() {
		this.cantAtaques++;
	}
	
	public int getCantidadDeAtaques() {
		return cantAtaques;
	}
	public boolean estaRebelde() {
		return (this.cantAtaques>=3);
	}
}
