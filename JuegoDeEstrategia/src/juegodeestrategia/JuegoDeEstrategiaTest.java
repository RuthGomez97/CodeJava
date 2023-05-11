package juegodeestrategia;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoDeEstrategiaTest {

	@Test
	public void soldadoTest() {
		Soldado rambo=  new Soldado(new Punto(1,1));
		Soldado rocky= new Soldado(new Punto(1,1));
		int esperado= 200;
		int obtenido=rocky.getSalud();
		assertEquals(esperado,obtenido);
		rambo.atacar(rocky);
		int esperado1=90;
		int obtenido1=rambo.getEnergia();
		assertEquals(esperado1,obtenido1);
		int esperado2=190;
		int obtenido2=rocky.getSalud();
		assertEquals(esperado2,obtenido2);
		
		
	  }
	@Test
	public void soldadoconescudo() {
		Unidad rambo=  new Soldado(new Punto(1,1));
		Soldado rocky= new Soldado(new Punto(1,1));
		rambo=new Escudo(rambo);
		rocky.atacar(rambo);
		rocky.atacar(rambo);
		assertEquals(192,rambo.getSalud());
		assertEquals(80,rocky.getEnergia());
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.beberAgua();
		rambo.atacar(rocky);
		rambo.atacar(rocky);
	    assertEquals(100,rocky.getSalud());
		assertEquals(true,rambo.puedeAtacar(rocky));
		
	}
	@Test
	public void arquerosYLancerosConCapaTest() {
		Unidad peter= new Soldado(new Punto(1,0));
		Unidad rambo= new Soldado(new Punto(1,0));
		Unidad maxi= new Arquero(new Punto(3,0));
		Unidad pedro=new Arquero(new Punto(1,0));
		peter = new Capa(peter);
		peter.atacar(rambo);
		peter.atacar(rambo);
		maxi.atacar(peter);
		rambo.atacar(peter); 
		
		assertEquals(185,peter.getSalud());
		assertEquals(160,peter.getEnergia());
		assertEquals(198,rambo.getSalud());
		peter.atacar(pedro);
		assertEquals(49,pedro.getSalud());
	}
	@Test
	public void caballerovsLanceroTest() {
		Caballo tiroalblanco=new Caballo();
		Unidad lucas= new Caballero(new Punto(1,0),tiroalblanco);
		Unidad pablo= new Lancero(new Punto(2,0));
		lucas.atacar(pablo);
		assertEquals(100,pablo.getSalud());
		pablo.atacar(lucas);
		assertEquals(175,lucas.getSalud());
		lucas=new Punal(lucas);
		
		lucas.atacar(pablo);
		assertEquals(47,pablo.getSalud());
		pablo.atacar(lucas);
		assertEquals(147,lucas.getSalud());
		lucas=new Escudo(lucas);
		//lucas.atacar(pablo);
		//assertEquals(0,pablo.getSalud());
		pablo.atacar(lucas);
		assertEquals(137,lucas.getSalud());
	}
	@Test
	public void ArvsLanvsSolvsCabConPoderestest() {
		Caballo tiroalblanco=new Caballo();
		Unidad lucas= new Caballero(new Punto(1,0),tiroalblanco);
		Unidad pablo= new Lancero(new Punto(2,0));
		Unidad rocky= new Soldado(new Punto(3,0));
		Unidad robin=new Arquero(new Punto(3,0));
		Unidad peter= new Soldado(new Punto(1,0));
		robin=new Escudo(robin);
		pablo.atacar(robin);
		assertEquals(40,robin.getSalud());
		rocky.atacar(robin);
		assertEquals(36,robin.getSalud());
		peter=new Capa(peter);
		peter.atacar(lucas);
		assertEquals(199,lucas.getSalud());
		assertEquals(180,peter.getEnergia());
		pablo=new Punal(pablo);
		pablo.atacar(robin);
		//me da 25 puesto que robin tiene un escudo y en lugar de recibir el daño que es 28 recibe solo el 40% del danio que es 11
		assertEquals(25,robin.getSalud());
		lucas.atacar(pablo);
		assertEquals(97,pablo.getSalud());	
		
	}
	@Test
	public void soldadoAtacaMuchasVecesTest() {
		Soldado rambo= new Soldado(new Punto(1,1));
		Soldado rocky= new Soldado(new Punto(1,1));
		rambo.atacar(rocky);
		rambo.atacar(rocky); 
		rambo.atacar(rocky);
		rambo.atacar(rocky); 
		rambo.atacar(rocky);
		assertEquals(50,rambo.getEnergia());
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky); 
		rambo.atacar(rocky);
		assertEquals(100,rocky.getSalud());
		assertEquals(0,rambo.getEnergia());
		rambo.atacar(rocky);
		assertEquals(100,rocky.getSalud());
		rambo.beberAgua();
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		assertEquals(0,rocky.getSalud());
		assertEquals(100,rocky.getEnergia());
	}
	
	@Test 
	public void AtacarEstandoMuertoTest() {
		Soldado rambo= new Soldado(new Punto(1,1));
		Soldado rocky= new Soldado(new Punto(1,1));
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.beberAgua();
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rambo.atacar(rocky);
		rocky.atacar(rambo);
		rambo.atacar(rocky);
		//aca rocky ya esta funado por lo tanto no puede atacar
		rocky.atacar(rambo);
		assertEquals(true,rocky.estaMuerto());
		assertEquals(90,rocky.getEnergia());
		assertEquals(0,rocky.getSalud());
		assertEquals(190,rambo.getSalud());
	}
	
	@Test
	public void atacarArquerovsArqueroTest() {
		Arquero peter=new Arquero(new Punto(6,4));
		Arquero robin=new Arquero(new Punto(2,2));
		peter.atacar(robin);
		assertEquals(45,robin.getSalud());
		assertEquals(19,peter.getFlechas());
		peter.atacar(robin);
		peter.atacar(robin);
		peter.atacar(robin);
		peter.atacar(robin);
		peter.atacar(robin);
		peter.atacar(robin);
		peter.atacar(robin);
		peter.atacar(robin);
		peter.atacar(robin);
		//aca robin ya esta muerto por lo que no puede atacar a peter
		robin.atacar(peter);
		assertEquals(0,robin.getSalud());
		assertEquals(10,peter.getFlechas());
		assertEquals(50,peter.getSalud());
	}
	
	@Test
	public void atacarArquerovsSoldadoTest() {
		Arquero robin=new Arquero(new Punto(2,2));
		Soldado rocky= new Soldado(new Punto(2,2));
		Arquero peter=new Arquero(new Punto(6,4));
		peter.atacar(robin);
		peter.atacar(rocky);
		assertEquals(45,robin.getSalud());
		rocky.atacar(robin);
		assertEquals(195,rocky.getSalud());
		assertEquals(35,robin.getSalud());
		//rocky no puede atacar a peter porque esta lejos del rango
		//peter si puede atacar a rocky
		rocky.atacar(peter);
		assertEquals(90,rocky.getEnergia());
		assertEquals(50,peter.getSalud());
	   while(peter.puedeAtacar(rocky)) {
		   peter.atacar(rocky);
	   }
	   assertEquals(1,peter.getFlechas());
	   assertEquals(110,rocky.getSalud());
	   peter.recargarFlechas();
	   peter.atacar(rocky);
	   peter.atacar(rocky);
	   assertEquals(100,rocky.getSalud());
	   assertEquals(5,peter.getFlechas());
	   
	   while(rocky.puedeAtacar(robin)) {
		   rocky.atacar(robin);
	   }
	   assertEquals(0,robin.getSalud());
	   assertEquals(0,rocky.getEnergia());
	}
	@Test
	public void lancerosAtacandoseTest(){
		Lancero lancerito= new Lancero(new Punto(5,5 ));
		Lancero lince=new Lancero(new Punto(3,3));
		lancerito.atacar(lince);
		assertEquals(125,lince.getSalud());
	}
	
	@Test
	public void lancerosAtacanHastaMatarseTest(){
		Lancero lancerito= new Lancero(new Punto(5,5 ));
		Lancero lince=new Lancero(new Punto(3,3));
		lancerito.atacar(lince);
		lancerito.atacar(lince);
		lancerito.atacar(lince);
		lancerito.atacar(lince);
		lancerito.atacar(lince);
		lancerito.atacar(lince);
		assertEquals(0,lince.getSalud());
		//esta muerto por lo tanto ya no puede atacar
		lince.atacar(lancerito);
		assertEquals(150,lancerito.getSalud());
	}
	
	@Test
	public void LanceroVsArquerovsSoldadoTest() {
		Lancero lince= new Lancero(new Punto(3,2));
		Arquero peter= new Arquero(new Punto(1,2));
		Soldado rocky= new Soldado(new Punto(3,2));
		
		lince.atacar(peter);
		assertEquals(25,peter.getSalud());
		peter.atacar(lince);
		assertEquals(145,lince.getSalud());
		//un lancero no puede atacar a una distancia de 0 por eso el soldado no es atacado
		lince.atacar(rocky);
		assertEquals(200,rocky.getSalud());
		//ahora veamos como el soldado ataca al lancero
		rocky.atacar(lince);
		assertEquals(135,lince.getSalud());
		assertEquals(90,rocky.getEnergia());
		//ahora veamos como rocky no puede atacar al Arquero porque esta lejos
		rocky.atacar(peter);
		assertEquals(25,peter.getSalud());
		//pero el arqueor puede matar a Rocky el soldado
		while(peter.puedeAtacar(rocky)) {
			peter.atacar(rocky);
		}
        //peter pudo atacarlo pero solamente hasta que tuviera flechas 
		assertEquals(110,rocky.getSalud());
		peter.recargarFlechas();
		peter.recargarFlechas();
		peter.recargarFlechas();
		peter.recargarFlechas();
		while(peter.puedeAtacar(rocky)) {
			peter.atacar(rocky);
		}
		assertEquals(0,rocky.getSalud());
		//como vemos el solsado ya no puede atacar porque esta muerto 
		rocky.atacar(lince);
		assertEquals(135,lince.getSalud());
		
	}
	@Test
	public void CaballeroTest() {
		Caballo caballito=new Caballo();
		Caballo salvaje=new Caballo();
		Caballero carlos = new Caballero(new Punto(1,1),caballito);
		Caballero gabi= new Caballero(new Punto(2,1),salvaje);
		
		carlos.atacar(gabi);
		carlos.atacar(gabi);
		carlos.atacar(gabi);
		carlos.atacar(gabi);
		assertEquals(true,caballito.estaRebelde());
		assertEquals(50,gabi.getSalud());
		carlos.beberAgua();
		carlos.atacar(gabi);
		carlos.atacar(gabi);
		assertEquals(false,caballito.estaRebelde());
		assertEquals(0,gabi.getSalud());
	
	}
	@Test
	public void CaballerovsSoldado(){
		Caballo caballito=new Caballo();
		Caballo salvaje=new Caballo();
		Caballero carlos = new Caballero(new Punto(1,1),caballito);
		Caballero gabi= new Caballero(new Punto(2,1),salvaje);
		Soldado rambo=new Soldado(new Punto(1,1));
		rambo.atacar(carlos);
		assertEquals(190,carlos.getSalud());
		assertEquals(90,rambo.getEnergia());
		gabi.atacar(rambo);
		assertEquals(150,rambo.getSalud());
		gabi.atacar(rambo);
		gabi.atacar(rambo);
		gabi.atacar(rambo);
		assertEquals(50,rambo.getSalud());
		gabi.beberAgua();
		gabi.atacar(rambo);
		assertEquals(0,rambo.getSalud());
	}
	@Test
	public void caballerovsArquero() {
		Caballo caballito=new Caballo();
		Caballero gabi= new Caballero(new Punto(3,0),caballito);
		Arquero peter=new Arquero(new Punto(1,0));
		Soldado rocky= new Soldado(new Punto(1,0));
		peter.atacar(gabi);
		assertEquals(195,gabi.getSalud());
		peter.atacar(gabi);
		peter.atacar(gabi);
		peter.atacar(gabi);	
		assertEquals(180,gabi.getSalud());
		gabi.atacar(peter);
		assertEquals(0,peter.getSalud());
		gabi.atacar(rocky);
		assertEquals(150,rocky.getSalud());
		gabi.atacar(rocky);
		gabi.atacar(rocky);
		assertEquals(100,rocky.getSalud());
	}
	@Test
	public void CaballerovsLancerovsArquerovsSoldadoTest() {
		Caballo caballito=new Caballo();
		Caballo lazaro=new Caballo();
		Caballero gabi= new Caballero(new Punto(3,0),caballito);
		Arquero peter=new Arquero(new Punto(1,0));
		Soldado rocky= new Soldado(new Punto(1,0));
		Lancero goku= new Lancero(new Punto(2,0));
		Arquero jose=new Arquero(new Punto(5,0));
		Caballero carlos=new Caballero(new Punto(1,0),lazaro);
		//gabi ataca a todos
	    gabi.atacar(goku);
	    assertEquals(100,goku.getSalud());
	    gabi.atacar(rocky);
	    assertEquals(150,rocky.getSalud());
	    gabi.atacar(peter);
	    assertEquals(0,peter.getSalud());
	    //peter Ataca
	    while(jose.puedeAtacar(gabi)) {
	    	jose.atacar(gabi);
	    }
	    assertEquals(105,gabi.getSalud());
	    jose.recargarFlechas();
	    jose.recargarFlechas();
	    jose.atacar(goku);
	    assertEquals(95,goku.getSalud());
	    jose.atacar(gabi);
	    assertEquals(100,gabi.getSalud());
	    jose.atacar(rocky);
	    assertEquals(145,rocky.getSalud());
	    
	    //goku se venga
	    goku.atacar(gabi);
	    assertEquals(75,gabi.getSalud());
	    goku.atacar(rocky);
	    assertEquals(120,rocky.getSalud());
	    goku.atacar(jose);
        assertEquals(25,jose.getSalud());
        //rocky pelea
        rocky.atacar(carlos);//1
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);//11
        assertEquals(100,carlos.getSalud());
        rocky.beberAgua();
        rocky.atacar(carlos); 
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
        rocky.atacar(carlos);
	    assertEquals(40,carlos.getSalud());
	    rocky.atacar(carlos);
	    rocky.atacar(carlos);
	    rocky.atacar(carlos);
	    rocky.atacar(carlos);
	    //rocky quedo sin energia suficiente para atacar
	    assertEquals(0,carlos.getSalud());
	    //carlos no puede atacar a rocky porque estan muy cerca y ataca a una distancia de 1 a 3
	    carlos.atacar(rocky);
	    carlos.atacar(rocky);
	    assertEquals(120,rocky.getSalud());
	    //pero gabi venga a carlos
	    //primero debe calmar al caballo
	    gabi.beberAgua();
	    gabi.atacar(rocky);
	    gabi.atacar(rocky);
	    gabi.atacar(rocky);
	    assertEquals(0,rocky.getSalud());
	    //fin del combate sobrevive gabi,
	}
	    
}
	