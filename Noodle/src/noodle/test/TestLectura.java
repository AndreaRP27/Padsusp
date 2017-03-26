package noodle.test;

import noodle.Noodle;
import noodle.usuario.*;

public class TestLectura {
	public static void main(String[] args){
		Noodle.cargar();
		for (Usuario u: Noodle.getInstance().getUsuarios()){
			System.out.println(u);
		}
		
		/* Vemos que si no se hace login el usuario actual es null*/
		System.out.println("\n" + Noodle.getInstance().getCur_usr());
		
		/*Intentamos hacer login con una clave erronea y falla*/
		Noodle.login(0000, "Andreaes");
		System.out.println("\n" + Noodle.getInstance().getCur_usr());
		
		/*Hacemos login como profesor */
		Noodle.login(0000, "AndreaesGuapa");
		System.out.println("\n" + Noodle.getInstance().getCur_usr());
		
		/* Creamos unos curso */
		Noodle.crearAsignatura("Calculo II", "FUBINI");
		Noodle.crearAsignatura("Probabilidad", "Chebyshev");
		System.out.println("\n" + Noodle.getInstance().getCursos());
		
		/* Eliminamos un curso */
		Noodle.eliminarAsignatura("Probabilidad");
		System.out.println("\n" + Noodle.getInstance().getCursos());
		
		/* Hacemos logout*/
		Noodle.logout();
		System.out.println("\n" + Noodle.getInstance().getCur_usr());
		
		/* Creamos un curso fuera de hacer login*/
		Noodle.crearAsignatura("Adsof", "Es un coñazo");
		System.out.println("\n" + Noodle.getInstance().getCursos());
		
		/*Hacemos login como alumno */
		Noodle.login(1264, "s.ll");
		System.out.println("\n" + Noodle.getInstance().getCur_usr());
		
		/* Creamos un curso como alumno y no deja*/
		Noodle.crearAsignatura("Adsof", "Es un coñazo");
		System.out.println("\n" + Noodle.getInstance().getCursos());
	
		/* Saliendo de Noodle */
		Noodle.quit();
		
		System.out.println("No sale de forma correcta");
		
	}
}