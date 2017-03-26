package noodle.asignatura;

public class Apuntes implements java.io.Serializable {

	private static final long serialVersionUID = 1;
	private String nombre;
	private String contenido;
	private Boolean visibilidad;
	
	//Constructor
	public Apuntes(String nombre, String contenido, Boolean visibilidad) {
		this.nombre = nombre;
		this.contenido = contenido;
		this.visibilidad = visibilidad;
	}
	
	//Getters
	public String getNombre(){
		return this.nombre;
	}
	
	public String getContenido(){
		return this.contenido;
	}
	
	public Boolean getVisibilidad(){
		return this.visibilidad;
	}
	
	//Setters
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setContenido(String contenido){
		this.contenido = contenido;
	}
	
	public void setVisibilidad(Boolean visibilidad){
		this.visibilidad = visibilidad;
	}
	
	//Other methods
	public Boolean isVisible(){
		if (visibilidad == true){
			return true;
		}
		
		return false;
	}
	
	public void verApuntes(){
		System.out.println(nombre);
		System.out.println(contenido);
	}

	@Override
	public String toString() {
		return "Apuntes [nombre=" + nombre + ", contenido=" + contenido + ", visibilidad=" + visibilidad + "]";
	}

	
}
