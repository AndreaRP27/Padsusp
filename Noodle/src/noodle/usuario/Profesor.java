package noodle.usuario;

import noodle.asignatura.*;
import noodle.asignatura.ejercicio.Ejercicio;
import noodle.asignatura.ejercicio.Pregunta;
import noodle.estadistica.*;
import noodle.*;

public class Profesor extends Usuario {
	
	private static final long serialVersionUID = 1;

	public Profesor(int id, String contrasenia, String email) {
		super(id, contrasenia, email);
	}

	public void expulsarAlumnoCurso(Alumno a, Curso c){
		if(c.getAlumnos().contains(a)){
			c.getAlumnos().remove(a);
			c.getExpulsados().add(a);
		}
	
	}
	
	public void readmitirAlumnoCurso(Alumno a, Curso c){
		if(c.getExpulsados().contains(a)){
			c.getExpulsados().remove(a);
			c.getAlumnos().add(a);
		}
		
	}
	
	public void admitirAlumnoCurso(Alumno a, Curso c){
		if(c.getSolicitados().contains(a)){
			c.getSolicitados().remove(a);
			c.getAlumnos().add(a);
		}
		
	}
	
	public void rechazarAlumnoCurso(Alumno a, Curso c){
		if(c.getSolicitados().contains(a)){
			c.getSolicitados().remove(a);
		}
	
	}
	
	public void verEstadisticaEjercicio(Ejercicio e){
		
	}
	
	public void verEstadisticaPregunta(Pregunta p){
		
	}
	
	@Override
	public Curso crearAsignatura(String nombre, String descripcion){
		for(Curso c : Noodle.getInstance().getCursos()){
			if(c.getNombre().equals(nombre)){
				/* Ya está creado un curso con ese nombre */
				return null;
			}
		}
		Curso curso = new Curso(nombre, descripcion);
		Noodle.getInstance().addCurso(curso);
		return curso;
	}
	
	@Override
	public void solicitar(Curso c){};
	
	@Override
	public void eliminarAsignatura(String nombre){
		Curso curso = null;
		for(Curso c : Noodle.getInstance().getCursos()){
			if(c.getNombre().equals(nombre)){
				curso = c;
			}
		}
		Noodle.delCurso(curso);
	}
	
	public void crearTema(Curso c, String nombre, boolean visibilidad){
		if(Noodle.getInstance().getCursos().contains(c) == false)
			return;
		
		c.crearTema(nombre, visibilidad);
	}
	
	public void crearEjercicio(String nombre){
		//Comprobar ruta es :/Curso/Tema1/Tema2.../Teman
		
		//Ejercicio t = new Ejercicio(nombre, this.getRuta());
				
		//Asignar al array de Noodle
	}
	
	public void crearApuntes(String nombre, String contenido, boolean visible, Curso c, Tema t){
		
		if(Noodle.getInstance().getCursos().contains(c) == false)
			return;
		if(c.getTemas().contains(t) == false)
			return;
		
		t.crearApuntes(nombre, contenido, visible);
		
	}
	
	
	public void eliminarTema(Curso c, Tema t){
		if(Noodle.getInstance().getCursos().contains(c) == false)
			return;
		if(c.getTemas().contains(t))
			return;
		
		c.borrarTema(t);
		
	}
	
	public void borrarEjercicio(Ejercicio e){
		
	}
	
	public void borrarApuntes(Curso c, Tema t, Apuntes a){
		
	}
	
	public Boolean responderSolicitud(){
		return false;
	}
	
	public void verCalificaciones(Curso c){
		
	}
	
	public void verCalificacionesEjercicio(Ejercicio e){
		
	}
	
	public EstadisticaEjercicio getEstadisticaEjercicio(Ejercicio e){
		return null;
	}
	
	public EstadisticaPregunta getEstadisticaPregunta(Ejercicio e){
		return null;
	}
	
	public Boolean setVisibilidadTema(Apuntes t, Boolean b){
		return true;
	}
	
	public Boolean setVisibilidadApuntes(Apuntes a, Boolean b){
		return true;
	}
	
	public Boolean setVisibilidadEjercicio(Ejercicio e, Boolean b){
		return true;
	}
	
	public String toString(){
		return "Profesor" + "{" + super.toString() + "}";
	}
}