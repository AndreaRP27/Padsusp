package noodle.asignatura.ejercicio;

import java.util.ArrayList;
import java.time.LocalDate;
import noodle.estadistica.*;

public class Ejercicio {
	
	private static int nextId = 1;
	private int identificador;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private double ponderacion;
	private Boolean visibilidad;
	private int orden;
	private Boolean finalizado;
	private ArrayList <Pregunta> preguntas = new ArrayList <Pregunta> ();

	public Ejercicio(LocalDate fechaIni, LocalDate fechaFin, double ponderacion, Boolean
			visibilidad, int orden) {
		this.identificador = nextId;
		nextId++;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.ponderacion = ponderacion;
		this.visibilidad = visibilidad;
		this.orden = orden;
		this.finalizado = false;
		
		if(!isFechaValida(fechaIni, fechaFin))
			return;
	}
	
	//Getters
	public int getIdentificador(){
		return identificador;
	}
	
	public LocalDate getFechaIni(){
		return fechaIni;
	}
	
	public LocalDate getFechaFin(){
		return fechaFin;
	}
	
	public double getPonderacion(){
		return ponderacion;
	}
	
	public Boolean getVisibilidad(){
		return visibilidad;
	}
	
	public int getOrden(){
		return orden;
	}
	
	public Boolean getFinalizado(){
		return finalizado;
	}
	
	//Setters
	public void setIdentificador(int identificador){
		this.identificador = identificador;
	}
	
	public void setFechaIni(LocalDate fechaIni){
		this.fechaIni = fechaIni;
	}
	
	public void setFechaFin(LocalDate fechaFin){
		this.fechaFin = fechaFin;
	}
	
	public void setPonderacion(double ponderacion){
		this.ponderacion = ponderacion;
	}
	
	public void setVisibilidad(Boolean visibilidad){
		this.visibilidad = visibilidad;
	}
	
	public void setOrden(int orden){
		this.orden = orden;
	}
	
	public void setFinalizado(Boolean finalizado){
		this.finalizado = finalizado;
	}
	
	//Other methods
	public Pregunta crearPregunta(String tipo, double valor, String enunciado, double ponderacion, double resta){
		switch(tipo){
		case "Abierta":
			Abierta a = new Abierta(valor, enunciado, ponderacion, resta);
			preguntas.add(a);
			return a;
		case "Multiple":
			Multiple m = new Multiple(valor, enunciado, ponderacion, resta);
			preguntas.add(m);
			return m;
		case "Unica":
			Unica u = new Unica(valor, enunciado, ponderacion, resta);
			preguntas.add(u);
			return u;
		case "Simple":
			Simple s = new Simple(valor, enunciado, ponderacion, resta);
			preguntas.add(s);
			return s;
		default:
			return null;
		}
		
	}
	
	public void borrarPregunta(Pregunta p){
		if(preguntas.contains(p))
			preguntas.remove(p);
	}
	
	public void modificarPreguntaValor(Pregunta p, double valor){
		if(preguntas.contains(p)){
			p.setValor(valor);
		}
	}
	
	public void modificarPreguntaPonderacion(Pregunta p, double ponderacion){
		if(preguntas.contains(p)){
			p.setPonderacion(ponderacion);
		}
	}
	
	public void modificarPreguntaEnunciado(Pregunta p, String enunciado){
		if(preguntas.contains(p)){
			p.setEnunciado(enunciado);
		}
	}
	
	public void modificarPreguntaResta(Pregunta p, double resta){
		if(preguntas.contains(p)){
			p.setResta(resta);
		}
	}
	
	public Boolean modificarFecha(LocalDate fi, LocalDate ff){
		if(isFechaValida(fi, ff)){
			setFechaIni(fi);
			setFechaFin(ff);
			return true;
		}
		return false;
	}
	
	public Boolean isVisible(){
		if (visibilidad == true){
			return true;
		}
		
		return false;
	}
	
	public double calcularCalificacion(){
		return 0;
	}
	
	public EstadisticaEjercicio getEstadisticaEjercicio(){
		return null;
	}
	
	public EstadisticaPregunta getEstadisticaPregunta(Pregunta p){
		return null;
	}
	
	public void verCalificaciones(){
		
	}
	
	public Boolean isFechaValida(LocalDate fi, LocalDate ff){
		if(fi.isAfter(ff) || fi.isEqual(ff) || this.finalizado == true)
			return false;
		if(fechaFin != null)
			if (ff.isBefore(fechaFin))
				return false;
		return true;
	}
	
	public Boolean isFinalizado(){
		if (finalizado == true){
			return true;
		}
		
		return false;
	}

	public ArrayList <Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList <Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public void verEjercicio(){
		System.out.println("Ejercicio" + " " + identificador);
		for(Pregunta p: preguntas){
			System.out.print("Pregunta " + (preguntas.indexOf(p)+1) + ": ");
			p.verPregunta();
		}
	}
	
	public boolean acabarEjercicio(){
		int i = 1;
		//Comprobamos que todas las preguntas tienen al mismo una respuesta correcta
		for(Pregunta p: preguntas){
			if(i == 0){
				System.out.println("Hay preguntas sin respuesta correcta");
				return false;
			}
			i = 0;
			for(Respuesta r: p.getRespuestas())
				if(r.getCorrecta() == true){
					i = 1;
					break;
				}
		}
		
		return true;
	}
}
