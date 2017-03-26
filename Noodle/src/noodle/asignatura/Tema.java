package noodle.asignatura;

import java.time.LocalDate;
import java.util.ArrayList;

import noodle.asignatura.ejercicio.Ejercicio;

public class Tema implements java.io.Serializable {

	private static final long serialVersionUID = 1;
	private String titulo;
	private Boolean visibilidad;
	private ArrayList <Apuntes> apuntes = new ArrayList <Apuntes> ();
	private ArrayList <Ejercicio> ejercicios = new ArrayList <Ejercicio> ();
	
	//Constructor
	public Tema(String titulo, Boolean visibilidad) {
		this.titulo = titulo;
		this.visibilidad = visibilidad;
	}

	//Getters
	public String getTitulo() {
		return titulo;
	}
	
	public Boolean getVisibilidad() {
		return visibilidad;
	}

	//Setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	

	public void setVisible(Boolean visibilidad) {
		this.visibilidad = visibilidad;
	}

	//Other methods
	public Boolean isVisible(){
		if (visibilidad == true){
			return true;
		}
		return false;
	}
	
	public void crearApuntes(String nombre, String contenido, boolean visibilidad){
		// No podemos crear dos apuntes en el mismo tema con el mismo nombre
		for(Apuntes a: apuntes){
			if(a.getNombre() == nombre)
				return;
		}
		Apuntes a = new Apuntes(nombre, contenido, visibilidad);
		apuntes.add(a);
		
	}
	
	public void crearEjercicio(LocalDate fechaIni, LocalDate fechaFin, double ponderacion, Boolean
			visibilidad, int orden){
		Ejercicio e = new Ejercicio(fechaIni, fechaFin, ponderacion, visibilidad, orden);
		ejercicios.add(e);
	}
	
	
	public void borrarApuntes(Apuntes a){
		if(apuntes.contains(a))
			apuntes.remove(a);
		
	}
	
	public ArrayList <Apuntes> getApuntes(){
			return this.apuntes;
	}
	
	public void verTema(){
		System.out.println(titulo);
		
	}

	public ArrayList <Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(ArrayList <Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	@Override
	public String toString() {
		return "Tema [titulo=" + titulo + ", visibilidad=" + visibilidad + ", apuntes=" + apuntes + ", ejercicios="
				+ ejercicios + "]";
	}

	
}
