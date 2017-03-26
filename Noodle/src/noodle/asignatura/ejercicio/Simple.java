package noodle.asignatura.ejercicio;

public class Simple extends Pregunta {

	//Constructor
	
	public Simple(double valor, String enunciado, double ponderacion, double resta) {
		super(valor, enunciado, ponderacion,resta);
	}
	
	public Respuesta crearRespuesta(String texto, Boolean correcta){
		// Las preguntas de respuesta simple sólo tienen dos opciones posibles
		if(this.getRespuestas().size() == 2)
			return null;
		
		// En respuesta simple sólo puede haber una respuesta correcta
		for(Respuesta r: this.getRespuestas()){
			if (r.getCorrecta() == true)
				return null;			
		}
		return super.crearRespuesta(texto, correcta);
	}

}
