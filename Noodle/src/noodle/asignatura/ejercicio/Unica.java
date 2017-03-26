package noodle.asignatura.ejercicio;

public class Unica extends Pregunta {

	//Constructor

	public Unica(double valor, String enunciado, double ponderacion, double resta) {
		super(valor, enunciado, ponderacion, resta);
	}
	
	public Respuesta crearRespuesta(String texto, Boolean correcta){
		// Las preguntas de respuesta simple sólo tienen hasta 4 respuestas posibles
		if(this.getRespuestas().size() == 4)
			return null;
		// En respuesta única sólo puede haber una respuesta correcta
		for(Respuesta r: this.getRespuestas()){
			if (r.getCorrecta() == true)
				return null;			
		}
		return super.crearRespuesta(texto, correcta);
	}

}
