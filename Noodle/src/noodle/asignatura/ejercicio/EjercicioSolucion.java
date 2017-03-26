package noodle.asignatura.ejercicio;

public class EjercicioSolucion {
	
	private Boolean visibilidad;

	//Constructor
	public EjercicioSolucion(Boolean visibilidad) {
		this.visibilidad = visibilidad;
	}

	//Getters
	public Boolean getVisibilidad() {
		return visibilidad;
	}

	//Setters
	public void setVisibilidad(Boolean visibilidad) {
		this.visibilidad = visibilidad;
	}
	
	//Other methods
	public Boolean isVisible(){
		if (visibilidad == true){
			return true;
		}
		
		return false;
	}
	
	public Respuesta getRespuestaCorrecta(Pregunta p){
		return null;
	}
	
	public void verRespuestasCorrectas(){
		
	}

}
