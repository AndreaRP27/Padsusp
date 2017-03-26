package noodle.asignatura.ejercicio;

public class Multiple extends Pregunta {

	//Constructor

	public Multiple(double valor, String enunciado, double ponderacion, double resta) {
		super(valor, enunciado, ponderacion, resta);
	}
	
	public Respuesta crearRespuesta(String texto, Boolean correcta){
		// Las preguntas de respuesta multiple sólo tienen hasta 4 respuestas posibles
		if(this.getRespuestas().size() == 4)
			return null;
		return super.crearRespuesta(texto, correcta);
	}
}
