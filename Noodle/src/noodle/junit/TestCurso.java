package noodle.junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import noodle.asignatura.*;

public class TestCurso {
	
	private Curso c;
	
	@Before
	public void setUp() throws Exception{
		c = new Curso("Padsoft", "Proyecto de an�lisis y dise�o de sofware");
	}
	
	@Test
	public void testCrearTema() {
		Tema t = c.crearTema("An�lisis de requisitos", true);
		assertNull(t);
	}
	
	@Test
	public void testBorrarTema() {
		Tema t = c.crearTema("Dise�o", true);
		c.borrarTema(t);
		assert(c.getTemas().contains(t));		
	}
	
	

}
