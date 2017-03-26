package noodle.asignatura;

import noodle.Noodle;
import java.util.ArrayList;

import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import noodle.usuario.Alumno;
import noodle.usuario.Usuario;

public class Curso implements java.io.Serializable{
	private String nombre;
	private String descripcion;
	private static final long serialVersionUID = 1;
	private ArrayList <Tema> temas = new ArrayList <Tema> ();
	public ArrayList<Tema> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<Tema> temas) {
		this.temas = temas;
	}

	private ArrayList <Alumno> alumnos = new ArrayList <Alumno> ();
	private ArrayList <Alumno> expulsados = new ArrayList <Alumno> ();
	private ArrayList <Alumno> solicitado = new ArrayList <Alumno> ();
	
	
	//Constructor
	public Curso(String nombre, String descripcion){
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	//Getters
	public String getNombre(){
		return nombre;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	//Setters
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	//Other methods
	public Tema crearTema(String titulo, boolean visibilidad){
		// No podemos crear dos temas en el mismo curso con el mismo nombre
		for(Tema t: temas){
			if(t.getTitulo() == titulo)
				return null;
		}
	    Tema t = new Tema(titulo, visibilidad);	
		temas.add(t);
		return t;
	}
	
	public void borrarTema(Tema t){
		if(temas.contains(t))
			temas.remove(t);
	}
	
	public void verCalificaciones(){

	}
	
	public void verTema(Tema t){
		t.verTema();
	}

	public ArrayList <Alumno> getAlumnos() {
		return alumnos;
	}

	public void addAlumnos(Alumno alumno) {
		this.alumnos.add(alumno);
	}

	public ArrayList <Alumno> getExpulsados() {
		return expulsados;
	}

	public void expulsar(int id) {
		Alumno al2 = null;
		
		for(Alumno al : this.getAlumnos()){
			if(al.getIdentificador() == id){
				al2 = al;
				break;
			}
		}
		
		if(al2 == null)
			return;
		
		this.expulsados.add(al2);
		this.alumnos.remove(al2);
	}
	
	public void expulsar(Alumno u) {
		if(u == null)
			return;
		this.expulsar(u.getIdentificador());
	}

	public ArrayList <Alumno> getSolicitados() {
		return solicitado;
	}

	public void solicitar(Alumno u) {
		if(u == null)
			return;
		if(Noodle.getInstance().getUsuarios().contains(u) == false)
			return;
		if(this.alumnos.contains(u) || this.expulsados.contains(u))
			return;
		
		/* Enviar notificacion al profesor */
		try {
		EmailSystem.send("noodle@esdu.es", "Solicitud curso " + this.nombre, "El alumno/a " + u.getNombre() + " " + u.getApellidos() +
				" ha solicitado acceso al curso " + this.nombre);
		}
		catch (InvalidEmailAddressException exception){
			System.out.println("Correo erróneo");
		}
		catch (FailedInternetConnectionException exception){
			System.out.println("Sin conexión a internet");
		}
		
		this.solicitado.add(u);
	}
	
	public void solicitar(int id) {
		for(Usuario u : Noodle.getInstance().getUsuarios()){
			if(u.getIdentificador()==id){
				u.solicitar(this);
				return;
			}
		}
	}

	public void aceptar(Alumno u){
		if(u == null)
			return;
		
		if(this.getSolicitados().contains(u) == false)
			return;
		
		/* Enviar notificaciÃ³n al alumno*/
		
		this.solicitado.remove(u);
		this.alumnos.add(u);
		u.addCursosMat(this);
	}
	
	
	public void rechazar(Alumno u){
		if(u == null)
			return;
		
		if(this.getSolicitados().contains(u) == false)
			return;
				
		this.solicitado.remove(u);
	}
	
	@Override
	public String toString() {
		return "Curso [nombre= " + nombre + ", descripcion= " + descripcion + "]";
	}

	
}