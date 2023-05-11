package juegodeestrategia;

public class PruebadeJuego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arquero peter= new Arquero(new Punto(1,0));
		Unidad ricky=new Soldado(new Punto(1,0));
		Unidad lanzador=new Lancero(new Punto(1,0));
		peter.atacar(ricky);
		System.out.println(ricky.getSalud());
		ricky=new Escudo(ricky);
		lanzador=new Escudo(lanzador);
		peter.atacar(ricky);
		System.out.println(ricky.getSalud());
		while(ricky.puedeAtacar(peter)) {
			
			ricky.atacar(peter);
			System.out.println("r");
		}
		System.out.println(peter.getSalud());
		ricky.beberAgua();
		ricky.atacar(lanzador);
		System.out.println(lanzador.getSalud());
		

	}

}
