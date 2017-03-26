package noodle.asignatura.ejercicio;

import java.util.ArrayList;

public abstract class Pregunta {

	private double valor;
	protected String enunciado;
	private double ponderacion;
	private double resta;
	private ArrayList <Respuesta> respuestas = new ArrayList <Respuesta> ();

	public Pregunta(){
		
	}
	
	public Pregunta(double valor, String enunciado, double ponderacion, double resta) {
		this.valor = valor;
		this.enunciado = enunciado;
		this.ponderacion = ponderacion;
		this.resta = resta;
	}

	
	//Getters
	public double getValor() {
		return valor;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public double getPonderacion() {
		return ponderacion;
	}

	public double getResta() {
		return resta;
	}
	
	//Setters
	public void setValor(double valor) {
		if(valor >= 0)
			this.valor = valor;
	}
	
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public void setPonderacion(double ponderacion) {
		if(ponderacion >= 0)
			this.ponderacion = ponderacion;
	}
	
	public void setResta(double resta) {
		if(resta >= 0)
			this.resta = resta;
	}

	//Other methods
	
	public void modificarPregunta(double valor, String enunciado, double ponderacion, double resta){
		this.valor = valor;
		this.enunciado = enunciado;
		this.ponderacion = ponderacion;
		this.resta = resta;
	}
	
	public Respuesta crearRespuesta(String texto, Boolean correcta){
		Respuesta r = new Respuesta(texto, correcta);
		respuestas.add(r);
		return r;
	}
	
	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	public void verPregunta(){
		System.out.println(enunciado);
		for(Respuesta r: respuestas){
			r.verRespuesta();
		}
		System.out.println();
	}
}
