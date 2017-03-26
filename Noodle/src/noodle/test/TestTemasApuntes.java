package noodle.test;

import noodle.Noodle;
import noodle.asignatura.*;

public class TestTemasApuntes {
	
	public static void main(String[] args){
		Noodle.cargar();
		
		for(Curso c : Noodle.getInstance().getCursos()){
			System.out.println(c);
		}
		
		Curso cur = Noodle.getInstance().getCursos().get(0);
		
		Noodle.login(0000, "AndreaesGuapa");
		
		Noodle.getInstance().getCur_usr().crearTema(cur, "Lema de Zorn", true);
		
		System.out.println(cur.getTemas());
		
		Tema t = cur.getTemas().get(0);
		
		Noodle.getInstance().getCur_usr().crearApuntes("Zornication", "La zornicación es un proceso escasamente acaecido pero vital en la vida del estudiante medio de Matemáticas", true, cur, t);
		
		System.out.println(t.getApuntes());
		
		Noodle.quit();
	}
}
