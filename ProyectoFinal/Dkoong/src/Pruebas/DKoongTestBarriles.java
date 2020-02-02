package Pruebas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import Aplicacion.*;

public class DKoongTestBarriles {
	
	//Barril Azul
	
	@Test
	public void deberiaBajarEscaleraRotaBarrilAzul(){
		Board juego = new Board(652,618);
		juego.addBarrel("azul");
		juego.addPlataforma(new Posicion(0,156), new Posicion(569,156),2);
		juego.addBrokenStair(new Posicion(245,250), new Posicion(266,250), new Posicion(245,150), new Posicion(266,150));
		juego.getBarrels().get(0).changePosition(255, 156);
		juego.getBarrels().get(0).move(juego.getPlataformas(), juego.getStairs());
		int a = juego.getBarrels().get(0).getPosicion().getY();
		int b = juego.getBarrels().get(0).getPosicion().getX();
		assertEquals(a,158);	
	}
	
	@Test
	public void deberiaBajarEscaleraNormalBarrilAzul(){
		Board juego = new Board(652,618);
		juego.addBarrel("azul");
		juego.addPlataforma(new Posicion(0,156), new Posicion(569,156),2);
		juego.addNormalStair(new Posicion(245,250), new Posicion(266,250), new Posicion(245,150), new Posicion(266,150));
		juego.getBarrels().get(0).changePosition(255, 156);
		juego.getBarrels().get(0).move(juego.getPlataformas(), juego.getStairs());
		int a = juego.getBarrels().get(0).getPosicion().getY();
		int b = juego.getBarrels().get(0).getPosicion().getX();
		assertEquals(a,158);	
	}
	//Barril Amarillo
	
	@Test
	public void noDeberiaBajarEscalerasRotasBarrilAmarillo(){
		Board juego = new Board(652,618);
		juego.addBarrel("amarillo");
		juego.addPlataforma(new Posicion(0,156), new Posicion(569,156),2);
		juego.addBrokenStair(new Posicion(245,250), new Posicion(266,250), new Posicion(245,150), new Posicion(266,150));
		juego.getBarrels().get(0).changePosition(255, 156);
		juego.getBarrels().get(0).move(juego.getPlataformas(), juego.getStairs());
		int a = juego.getBarrels().get(0).getPosicion().getY();
		int b = juego.getBarrels().get(0).getPosicion().getX();
		assertEquals(a,156);
	}
	
	@Test
	public void noDeberiaBajarEscalerasNormalesBarrilAmarillo(){
		Board juego = new Board(652,618);
		juego.addBarrel("amarillo");
		juego.addPlataforma(new Posicion(0,156), new Posicion(569,156),2);
		juego.addNormalStair(new Posicion(245,250), new Posicion(266,250), new Posicion(245,150), new Posicion(266,150));
		juego.getBarrels().get(0).changePosition(255, 156);
		juego.getBarrels().get(0).move(juego.getPlataformas(), juego.getStairs());
		int a = juego.getBarrels().get(0).getPosicion().getY();
		int b = juego.getBarrels().get(0).getPosicion().getX();
		assertEquals(a,156);
	}
	
	//Barril Verde
	
	@Test
	public void noDeberiaBajarEscalerasRotasBarrilVerde(){
		Board juego = new Board(652,618);
		juego.addBarrel("verde");
		juego.addPlataforma(new Posicion(0,156), new Posicion(569,156),2);
		juego.addBrokenStair(new Posicion(245,250), new Posicion(266,250), new Posicion(245,150), new Posicion(266,150));
		juego.getBarrels().get(0).changePosition(255, 156);
		juego.getBarrels().get(0).move(juego.getPlataformas(), juego.getStairs());
		int a = juego.getBarrels().get(0).getPosicion().getY();
		int b = juego.getBarrels().get(0).getPosicion().getX();
		assertEquals(a,156);
	}
	
	@Test
	public void noDeberiaBajarEscalerasNormalesBarrilVerde(){
		Board juego = new Board(652,618);
		juego.addBarrel("verde");
		juego.addPlataforma(new Posicion(0,156), new Posicion(569,156),2);
		juego.addNormalStair(new Posicion(245,250), new Posicion(266,250), new Posicion(245,150), new Posicion(266,150));
		juego.getBarrels().get(0).changePosition(255, 156);
		juego.getBarrels().get(0).move(juego.getPlataformas(), juego.getStairs());
		int a = juego.getBarrels().get(0).getPosicion().getY();
		int b = juego.getBarrels().get(0).getPosicion().getX();
		assertEquals(a,156);
	}
	
	//Barril Rojo
	
	@Test
	public void deberiaSeguirDerechoBarrilRojo(){
		Board juego = new Board(652,618);
		juego.addBarrel("rojo");
		juego.addPlataforma(new Posicion(0,156), new Posicion(569,156),2);
		juego.getBarrels().get(0).changePosition(115, 156);
		juego.getBarrels().get(0).move(juego.getPlataformas(), juego.getStairs());
		int a = juego.getBarrels().get(0).getPosicion().getY();
		int b = juego.getBarrels().get(0).getPosicion().getX();
		assertEquals(a,158);
		
	}

}
