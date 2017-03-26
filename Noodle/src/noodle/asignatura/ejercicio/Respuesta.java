package noodle.asignatura.ejercicio;

public class Respuesta {
	
	private String texto;
	private Boolean correcta;
	private Boolean seleccionada;

	//Constructor
	public Respuesta(String texto, Boolean correcta) {
		this.setTexto(texto);
		this.setCorrecta(correcta);
	}

	//Getters
	public String getTexto() {
		return texto;
	}

	public Boolean getCorrecta() {
		return correcta;
	}
	
	public Boolean getSeleccionada() {
		return seleccionada;
	}

	
	//Setters
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}
	
	public void setSeleccionada(Boolean seleccionada) {
		this.seleccionada = seleccionada;
	}

	//Other methods
	public Boolean isCorrecta(){
		if (correcta == true){
			return true;
		}
		
		return false;
	}
	
	public Boolean isSeleccionada(){
		if (seleccionada == true){
			return true;
		}
		
		return false;
	}
	
	public void verRespuesta(){
		System.out.println(texto);
	}
	
	public void modificarRespuesta(String texto, boolean correcta){
		this.texto = texto;
		this.correcta = correcta;
	}
	
}
