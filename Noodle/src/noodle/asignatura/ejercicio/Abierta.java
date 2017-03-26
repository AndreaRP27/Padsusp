package noodle.asignatura.ejercicio;

public class Abierta extends Pregunta {
	
	private String[] correctas;

	//Constructor

	public Abierta(double valor, String enunciado, double ponderacion, double resta) {
		super(valor, enunciado, ponderacion, resta);
	}

	public String[] getCorrectas() {
		return correctas;
	}

	public void setCorrectas(String[] correctas) {
		this.correctas = correctas;
	}
	
	public void verPregunta(){
		System.out.println(enunciado);
		System.out.println("  [                   ]");
	}

}
