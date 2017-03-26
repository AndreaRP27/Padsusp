package noodle.usuario;

import noodle.asignatura.*;

public abstract class Usuario implements java.io.Serializable {
	private static final long serialVersionUID = 1;
	protected int identificador;
	protected String password;
	private String email;
	protected String ruta;
	
	public Usuario(int id, String contrasenia, String email){
		this.identificador = id;
		this.password = contrasenia;
		this.ruta = null;
		this.email = email;
	}
	
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String contrasenia) {
		this.password = contrasenia;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public Boolean logout(){
		return true;
	}
	
	public void accederCurso(Curso c){
	}
	
	public Curso buscarCurso(String str){
		return null;
	}
	
	public void verCurso(Curso c){
		
	}
	
	public void verTema(Tema t){
		t.verTema();
	}
	
	
	public abstract void solicitar(Curso c);
	
	public abstract Curso crearAsignatura(String nombre, String descripcion);
	
	public abstract void crearTema(Curso c, String nombre, boolean visibilidad);
	
	public abstract void crearApuntes(String nombre, String contenido, boolean visible, Curso c, Tema t);

	public abstract void eliminarAsignatura(String nombre);
	
	@Override
	public String toString() {
		return "[identificador= " + identificador + ", password= " + password + ", email= " + email + "]";
	}

}

