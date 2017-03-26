package noodle.usuario;
import java.util.ArrayList;

import noodle.asignatura.*;
import noodle.asignatura.ejercicio.Ejercicio;
import noodle.calificacion.*;

public class Alumno extends Usuario {
	
	private static final long serialVersionUID = 1;
	private String nombre;
	private String apellidos;
	private ArrayList <Curso> cursosMat = new ArrayList <Curso> ();
	
	public Alumno(int id, String contrasenia, String nombre, String apellidos, String email) {
		super(id, contrasenia, email);
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	// Métodos de alumno
	
	public void verCalificaciones(){
		
	}

	@Override
	public void solicitar(Curso c){
		//Un alumno no puede solicitar la admisi�n en un curso al que ya pertenece
		if(cursosMat.contains(c))
			return;
		c.solicitar(this);	
	}
	
	public void verCalificacion(Curso c){
		
	}
	
	/*(public RespuestaEjercicio getRespuestaEjercicio(Ejercicio ){
		ESTO TAL VEZ SE PUEDE HACER CON ESTADISTICA DE EJERCICIO COMO ESTA HECHO EN EL DIAGRAMA DE SECUENCIA
	}*/
	
	public Calificacion verCalificacion(Ejercicio e){
		return null;
	}
	
	//public SolucionEjercicio verSolucionEjercicio(Ejercicio e){
	//	return null;
	//}
	
	public void realizarEjercicio(Ejercicio e){
		
	}
	
	public void verTema(Tema t){
		if(t.getVisibilidad() == true)
			super.verTema(t);
	}
	
	public void crearTema(Curso c, String nombre, boolean visibilidad){}
	
	public void crearApuntes(String nombre, String contenido, boolean visible, Curso c, Tema t){
	}

	public ArrayList <Curso> getCursosMat() {
		return cursosMat;
	}

	public void addCursosMat(Curso curso) {
		this.cursosMat.add(curso);
	}
	
	@Override
	public Curso crearAsignatura(String nombre, String descripcion){
		return null;
	}

	@Override
	public void eliminarAsignatura(String nombre){
		
	}
	@Override
	public String toString() {
		return "Alumno" + "{"  + this.nombre + " " + this.apellidos + " ," + super.toString() + "}";
	}
	
	
}
